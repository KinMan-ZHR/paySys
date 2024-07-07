package com.kinman.paydemo.controller;

import com.kinman.paydemo.model.PaymentRequest;
import com.kinman.paydemo.model.PaymentResponse;
import com.kinman.paydemo.model.PaymentStatusResponse;
import com.kinman.paydemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> pay(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<PaymentStatusResponse> getStatus(@PathVariable String orderId) {
        PaymentStatusResponse response = paymentService.getPaymentStatus(orderId);
        return ResponseEntity.ok(response);
    }
}
