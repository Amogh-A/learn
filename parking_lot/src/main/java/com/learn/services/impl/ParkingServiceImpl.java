package com.learn.services.impl;

import com.learn.dtos.AvailableParkingRequest;
import com.learn.dtos.AvailableParkingResponse;
import com.learn.dtos.AvailableSpaceInLot;
import com.learn.entities.ParkingLotMaster;
import com.learn.entities.ParkingSpaceMaster;
import com.learn.repository.ParkingLotMasterRepository;
import com.learn.repository.ParkingSpaceMasterRepository;
import com.learn.services.ParkingService;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingLotMasterRepository parkingLotMasterRepository;

    @Autowired
    private ParkingSpaceMasterRepository parkingSpaceMasterRepository;

    private final Map<String, String> vehicleSpaceMapping = Map.of("car", "MEDIUM");

    @Override
    public List<AvailableParkingResponse> getAvailableParking(AvailableParkingRequest availableParkingRequest) {
        List<ParkingLotMaster> parkingLotMasterList = parkingLotMasterRepository.findAll();
        List<Tuple> parkingSpaceMasterList = parkingSpaceMasterRepository.getParkingSpaceByVehicleSize(vehicleSpaceMapping.get(availableParkingRequest.getVehicleType()));

//        List<AvailableParkingResponse> availableParkingResponses = parkingLotMasterList.stream().filter(ParkingLotMaster::getActive).map(x -> new AvailableParkingResponse(x.getId(), x.getName(), x.getAddress(), Math.sqrt(Math.pow(availableParkingRequest.getLatitude()-x.getLatitude(), 2)+Math.pow(availableParkingRequest.getLongitude()-x.getLongitude(), 2)), 0)).sorted(Comparator.comparing(AvailableParkingResponse::getDistance)).toList();
        Map<Long, List<Tuple>> tupleMap = parkingSpaceMasterList.stream().filter(val-> val.get(5, Boolean.class)).collect(Collectors.groupingBy(tuple -> tuple.get(0, Long.class)));
        List<AvailableParkingResponse> availableParkingResponses = new ArrayList<>();
        tupleMap.entrySet().forEach((e)->{
            Long lotId = e.getValue().get(0).get(0, Long.class);
            String parkingName = e.getValue().get(0).get(1, String.class);
            String parkingAddress = e.getValue().get(0).get(2, String.class);
            Double distance = Math.sqrt(Math.pow(availableParkingRequest.getLatitude()-e.getValue().get(0).get(3, Double.class), 2)+Math.pow(availableParkingRequest.getLongitude()-e.getValue().get(0).get(4, Double.class), 2));
            int availableSlots = e.getValue().size();

            availableParkingResponses.add(new AvailableParkingResponse(lotId, parkingName, parkingAddress, distance, availableSlots));

        });
        return availableParkingResponses;

    }

    @Override
    public List<AvailableSpaceInLot> getAvailableSpace(Long lotId){
        List<ParkingSpaceMaster> parkingSpaceMasterList =  parkingSpaceMasterRepository.getParkingSpaceByParkingLotId(lotId);
        return parkingSpaceMasterList
                .stream()
                .collect(Collectors.groupingBy(x-> x.getParkingSpaceMeta().getSpaceSize(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry-> new AvailableSpaceInLot(entry.getKey(), entry.getValue()))
                .toList();
    }

    @Override
    public List<ParkingSpaceMaster> getAvailableSpace(Long lotId, String vehicleType) {
        return parkingSpaceMasterRepository.findParkingByLotoIdVehicleType(lotId, vehicleSpaceMapping.get(vehicleType));
    }


}
