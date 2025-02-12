package com.bcs.project.stpauls.repository;

import com.bcs.project.stpauls.model.Parent;
import com.bcs.project.stpauls.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
