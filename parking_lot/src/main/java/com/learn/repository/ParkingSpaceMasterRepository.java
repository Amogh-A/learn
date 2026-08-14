package com.learn.repository;

import com.learn.entities.ParkingSpaceMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceMasterRepository extends JpaRepository<ParkingSpaceMaster, Long>, ParkingSpaceMasterRepositoryCustom {
}
