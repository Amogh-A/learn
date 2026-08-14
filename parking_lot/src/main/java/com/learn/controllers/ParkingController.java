package com.learn.controllers;

import com.learn.dtos.*;
import com.learn.services.ParkingService;
import com.learn.services.TicketService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("available")
    public List<AvailableParkingResponse> getAvailableParking(@RequestParam String vehicleType, @RequestParam Double latitude, @RequestParam Double longitude){
        return parkingService.getAvailableParking(new AvailableParkingRequest(vehicleType, latitude, longitude));
    }

    @GetMapping("space")
    public List<AvailableSpaceInLot> getAvailableSpaceInLot(@RequestParam Long lotId){
        return parkingService.getAvailableSpace(lotId);
    }

    @PostMapping("enter")
    public TicketResponseDto enter(@RequestBody EnterRequestDto enterRequestDto){
        return ticketService.enter(enterRequestDto);
    }

    @GetMapping("exit")
    public Long exit(@RequestParam Long ticketId, @RequestParam Long exitGateId) throws BadRequestException {
         return ticketService.exit(ticketId, exitGateId);
    }

}
