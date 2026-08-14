package com.learn.repository;

import com.learn.entities.VehicleTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeMasterRepository extends JpaRepository<VehicleTypeMaster, Long> {

    VehicleTypeMaster findByType(String type);

}
