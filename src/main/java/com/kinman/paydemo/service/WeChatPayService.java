package com.kinman.paydemo.service;
import com.kinman.paydemo.model.PaymentRequest;
import com.kinman.paydemo.model.PaymentResponse;
import org.springframework.stereotype.Service;


@Service
public class WeChatPayService {
    public PaymentResponse pay(PaymentRequest request) {
        // 调用微信支付SDK实现支付逻辑
        PaymentResponse response = new PaymentResponse();
        response.setOrderId(request.getOrderId());
        response.setStatus("SUCCESS");
        response.setMessage("Payment processed successfully with WeChat Pay.");
        return response;
    }
}
