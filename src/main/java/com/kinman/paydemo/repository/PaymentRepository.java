package com.kinman.paydemo.repository;

import com.kinman.paydemo.model.PaymentResponse;
import com.kinman.paydemo.model.PaymentStatusResponse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {

    private final Map<String, PaymentResponse> paymentData = new HashMap<>();

    public void savePayment(PaymentResponse response) {
        paymentData.put(response.getOrderId(), response);
    }

    public PaymentStatusResponse getPaymentStatus(String orderId) {
        PaymentResponse response = paymentData.get(orderId);
        if (response == null) {
            return null;
        }
        PaymentStatusResponse statusResponse = new PaymentStatusResponse();
        statusResponse.setOrderId(response.getOrderId());
        statusResponse.setStatus(response.getStatus());
        return statusResponse;
    }
}