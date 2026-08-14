package com.learn.repository.impl;

import com.learn.entities.ParkingSpaceMaster;
import com.learn.entities.QParkingSpaceMaster;
import com.learn.enums.OccupancyStatus;
import com.learn.repository.ParkingSpaceMasterRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingSpaceMasterRepositoryImpl implements ParkingSpaceMasterRepositoryCustom {

    @Autowired
    private JPAQueryFactory factory;


    @Override
    public List<ParkingSpaceMaster> getParkingSpaceByParkingLotId(Long parkingLotId) {
        QParkingSpaceMaster parkingSpaceMaster =  QParkingSpaceMaster.parkingSpaceMaster;
        return factory.selectFrom(parkingSpaceMaster)
                .where(parkingSpaceMaster.parkingLot().id.eq(parkingLotId)
                        .and(parkingSpaceMaster.occupancyStatus.eq(OccupancyStatus.AVAILABLE))).fetch();
    }

    @Override
    public List<Tuple> getParkingSpaceByVehicleSize(String spaceSize){
        QParkingSpaceMaster parkingSpaceMaster = QParkingSpaceMaster.parkingSpaceMaster;
        return factory.select(parkingSpaceMaster.parkingLot().id
                ,parkingSpaceMaster.parkingLot().name
                ,parkingSpaceMaster.parkingLot().address
                ,parkingSpaceMaster.parkingLot().latitude
                ,parkingSpaceMaster.parkingLot().longitude
                ,parkingSpaceMaster.parkingLot().active)
                .from(parkingSpaceMaster)
                .where(parkingSpaceMaster.parkingSpaceMeta().spaceSize.eq(spaceSize)
                        .and(parkingSpaceMaster.occupancyStatus.eq(OccupancyStatus.AVAILABLE)))
                .fetch();

    }

    @Override
    public List<ParkingSpaceMaster> findParkingByLotoIdVehicleType(Long lotId, String vehicleType) {
        QParkingSpaceMaster parkingSpaceMaster = QParkingSpaceMaster.parkingSpaceMaster;
        return factory.selectFrom(parkingSpaceMaster)
                .where(parkingSpaceMaster.parkingLot().id.eq(lotId)
                        .and(parkingSpaceMaster.parkingSpaceMeta().spaceSize.eq(vehicleType))
                        .and(parkingSpaceMaster.occupancyStatus.eq(OccupancyStatus.AVAILABLE)))
                .fetch();
    }
}
