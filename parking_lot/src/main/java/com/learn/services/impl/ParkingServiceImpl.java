package com.learn.services.impl;

import com.learn.dtos.AvailableParkingRequest;
import com.learn.dtos.AvailableParkingResponse;
import com.learn.services.ParkingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Override
    public List<AvailableParkingResponse> getAvailableParking(AvailableParkingRequest availableParkingRequest) {
        return List.of();
    }
}
