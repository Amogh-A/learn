package com.learn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnterRequestDto {

    private final Map<String, String> vehicleSpaceMapping = Map.of("car", "MEDIUM");


    Long lotId;
    String vehicleType;
    String vehicleNumber;
    Long gateId;

    String getVehicleSpaceType(){
        return vehicleSpaceMapping.get(this.vehicleType);
    }

}
