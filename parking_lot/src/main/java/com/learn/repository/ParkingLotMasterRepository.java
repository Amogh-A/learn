package com.learn.repository;

import com.learn.entities.ParkingLotMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotMasterRepository extends JpaRepository<ParkingLotMaster, Long> {
}
