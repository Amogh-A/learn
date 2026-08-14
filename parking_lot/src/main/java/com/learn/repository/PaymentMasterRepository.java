package com.learn.repository;

import com.learn.entities.PaymentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMasterRepository extends JpaRepository<PaymentMaster, Long> {
}
