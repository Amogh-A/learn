package com.learn.repository;

import com.learn.entities.GateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateMasterRepository extends JpaRepository<GateMaster, Long> {
}
