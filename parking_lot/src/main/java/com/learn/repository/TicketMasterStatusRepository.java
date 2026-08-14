package com.learn.repository;

import com.learn.entities.TicketMasterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMasterStatusRepository extends JpaRepository<TicketMasterStatus, Long> {
}
