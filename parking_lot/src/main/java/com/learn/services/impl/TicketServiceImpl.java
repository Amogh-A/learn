package com.learn.services.impl;

import com.learn.dtos.AvailableSpaceInLot;
import com.learn.dtos.EnterRequestDto;
import com.learn.dtos.TicketResponseDto;
import com.learn.entities.ParkingSpaceMaster;
import com.learn.entities.TicketMaster;
import com.learn.enums.OccupancyStatus;
import com.learn.repository.*;
import com.learn.services.ParkingService;
import com.learn.services.TicketService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private GateMasterRepository gateMasterRepository;

    @Autowired
    private VehicleTypeMasterRepository vehicleTypeMasterRepository;

    @Autowired
    private TicketMasterStatusRepository ticketMasterStatusRepository;

    @Autowired
    private TicketMasterRepository ticketMasterRepository;

    @Autowired
    private ParkingSpaceMasterRepository parkingSpaceMasterRepository;

    private Map<Long, Object> locks = new ConcurrentHashMap<>();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @PostConstruct
    void run(){
        redisTemplate.opsForValue().set("Ping", "Pong");
    }

    private Boolean getLock(String lockKey, String lockValue){
        return redisTemplate
                .opsForValue()
                .setIfAbsent(lockKey, lockValue, Duration.ofMinutes(1));
    }

    @Override
    @Transactional
    public TicketResponseDto enter(EnterRequestDto enterRequestDto) throws Exception {
        String lockKey = "parking:lock:"+enterRequestDto.getLotId()+":"+enterRequestDto.getVehicleSpaceMapping();
        String lockValue = UUID.randomUUID().toString();
        Boolean acquire = false;
        int count = 0;
        while(!Boolean.TRUE.equals(acquire) && count<=12){
            acquire = getLock(lockKey, lockValue);
            if(acquire)
                break;
            Thread.sleep(5000);
            count++;

        }
        if(!acquire)
            throw new Exception("Could not process request");

        try {
            List<ParkingSpaceMaster> parkingSpaceMasterList = parkingService.getAvailableSpace(enterRequestDto.getLotId(), enterRequestDto.getVehicleType());
            if(parkingSpaceMasterList.isEmpty()){
                String reason = "No space available for vehicle type: "+enterRequestDto.getVehicleType();
                return new TicketResponseDto(Boolean.FALSE, reason, null);
            }
            ParkingSpaceMaster parkingSpaceMaster = parkingSpaceMasterList.getFirst();
            TicketMaster ticketMaster = TicketMaster.builder()
                    .parkingLot(parkingSpaceMaster.parkingLot)
                    .entryGate(gateMasterRepository.findById(enterRequestDto.getGateId()).get())
                    .vehicleType(vehicleTypeMasterRepository.findByType(enterRequestDto.getVehicleType().toUpperCase()))
                    .parkingSpace(parkingSpaceMaster)
                    .vehicleNumber(enterRequestDto.getVehicleNumber())
                    .entryTime(LocalDateTime.now())
                    .ticketStatus(ticketMasterStatusRepository.findById(1L).get())
                    .build();

            ticketMasterRepository.save(ticketMaster);
            parkingSpaceMaster.setOccupancyStatus(OccupancyStatus.OCCUPIED);
            parkingSpaceMasterRepository.save(parkingSpaceMaster);

            return new TicketResponseDto(Boolean.TRUE, null, ticketMaster);

        }finally {
            if(redisTemplate.opsForValue().get(lockKey).equals(lockValue))
                redisTemplate.delete(lockKey);

        }

    }

    @Override
    @Transactional
    public Long exit(Long ticketId, Long exitGateId) throws BadRequestException {
        TicketMaster ticketMaster = ticketMasterRepository.findById(ticketId).orElse(null);
        if(Objects.isNull(ticketMaster) || !ticketMaster.getTicketStatus().getStatus().equals("ACTIVE"))
            throw new BadRequestException("Invalid Ticket Id");
        ticketMaster.setExitGate(gateMasterRepository.findById(exitGateId).orElse(null));
        ticketMaster.setExitTime(LocalDateTime.now());
        ticketMaster.setTicketStatus(ticketMasterStatusRepository.findById(2L).get());
        ParkingSpaceMaster parkingSpaceMaster = ticketMaster.getParkingSpace();
        parkingSpaceMaster.setOccupancyStatus(OccupancyStatus.AVAILABLE);

        Long hours = Duration.between(ticketMaster.getEntryTime(), ticketMaster.getExitTime()).toHours();
        Long amount = hours<=1?40:40+(hours-1)*20;

        ticketMasterRepository.save(ticketMaster);
        parkingSpaceMasterRepository.save(parkingSpaceMaster);
        return amount;
    }
}
