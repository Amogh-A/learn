package com.learn.services;

import com.learn.dtos.AvailableParkingRequest;
import com.learn.dtos.AvailableParkingResponse;

import java.util.List;

public interface ParkingService {

    List<AvailableParkingResponse> getAvailableParking(AvailableParkingRequest availableParkingRequest);
}
