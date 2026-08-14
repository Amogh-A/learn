package com.learn.repository;

import com.learn.entities.ParkingSpaceMaster;
import com.querydsl.core.Tuple;

import java.util.List;

public interface ParkingSpaceMasterRepositoryCustom{

    List<ParkingSpaceMaster> getParkingSpaceByParkingLotId(Long parkingLotId);

    List<Tuple> getParkingSpaceByVehicleSize(String spaceSize);

    List<ParkingSpaceMaster> findParkingByLotoIdVehicleType(Long lotId, String vehicleType);
}
