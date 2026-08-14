package com.learn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableParkingResponse {
    Long lotId;
    String parkingLotName;
    String address;
    double distance;
    int availableSlots;
}
