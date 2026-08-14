package com.learn.repository;

import com.learn.entities.ParkingSpaceMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceMetaRepository extends JpaRepository<ParkingSpaceMeta, Long> {
}
