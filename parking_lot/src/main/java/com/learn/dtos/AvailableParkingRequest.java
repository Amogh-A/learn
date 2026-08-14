package com.learn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AvailableParkingRequest {
    String vehicleType;
    double latitude;
    double longitude;
}
