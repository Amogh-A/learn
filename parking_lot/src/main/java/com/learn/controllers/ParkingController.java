package com.learn.controllers;

import com.learn.dtos.AvailableParkingRequest;
import com.learn.dtos.AvailableParkingResponse;
import com.learn.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("available")
    public List<AvailableParkingResponse> getAvailableParking(@RequestBody AvailableParkingRequest availableParkingRequest){
        return parkingService.getAvailableParking(availableParkingRequest);
    }

}
