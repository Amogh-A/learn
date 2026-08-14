package com.learn.repository;

import com.learn.entities.ParkingFloorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorMasterRepository extends JpaRepository<ParkingFloorMaster, Long> {
}
