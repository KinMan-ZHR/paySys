package com.kinman.paydemo.service;

import com.kinman.paydemo.model.PaymentRequest;
import com.kinman.paydemo.model.PaymentResponse;
import org.springframework.stereotype.Service;


@Service
public class AlipayService {
    public PaymentResponse pay(PaymentRequest request) {
        // 调用支付宝SDK实现支付逻辑
        PaymentResponse response = new PaymentResponse();
        response.setOrderId(request.getOrderId());
        response.setStatus("SUCCESS");
        response.setMessage("Payment processed successfully with Alipay.");
        return response;
    }
}
