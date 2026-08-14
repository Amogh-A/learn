package com.learn.repository;

import com.learn.entities.VehicleTypeParkingSpaceMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeParkingSpaceMapperRepository extends JpaRepository<VehicleTypeParkingSpaceMapper, Long> {
}
