package com.learn.repository;

import com.learn.entities.TicketMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMasterRepository extends JpaRepository<TicketMaster, Long> {
}
