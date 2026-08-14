package com.learn.services;

import com.learn.dtos.AvailableParkingRequest;
import com.learn.dtos.AvailableParkingResponse;
import com.learn.dtos.AvailableSpaceInLot;
import com.learn.entities.ParkingSpaceMaster;

import java.util.List;

public interface ParkingService {

    List<AvailableParkingResponse> getAvailableParking(AvailableParkingRequest availableParkingRequest);

    List<AvailableSpaceInLot> getAvailableSpace(Long lotId);

    List<ParkingSpaceMaster> getAvailableSpace(Long lotId, String vehicleType);
}
