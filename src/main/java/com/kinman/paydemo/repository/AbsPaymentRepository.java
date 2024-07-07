package com.kinman.paydemo.repository;


import com.kinman.paydemo.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsPaymentRepository extends JpaRepository<PaymentEntity, String> {

}
