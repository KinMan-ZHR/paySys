package com.kinman.paydemo.service;

import com.kinman.paydemo.mapper.PaymentMapper;
import com.kinman.paydemo.model.PaymentEntity;
import com.kinman.paydemo.model.PaymentRequest;
import com.kinman.paydemo.model.PaymentResponse;
import com.kinman.paydemo.model.PaymentStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private AlipayService alipayService;

    @Autowired
    private WeChatPayService weChatPayService;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentResponse processPayment(PaymentRequest request) {
        PaymentResponse response;
        switch (request.getPaymentMethod()) {
            case "ALIPAY":
                response = alipayService.pay(request);
                break;
            case "WECHAT_PAY":
                response = weChatPayService.pay(request);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported payment method: " + request.getPaymentMethod());
        }

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setOrderId(response.getOrderId());
        paymentEntity.setStatus(response.getStatus());
        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setPaymentMethod(request.getPaymentMethod());

        paymentMapper.insert(paymentEntity);

        return response;
    }

    public PaymentStatusResponse getPaymentStatus(String orderId) {
        PaymentEntity paymentEntity = paymentMapper.selectById(orderId);
        if (paymentEntity == null) {
            return null;
        }

        PaymentStatusResponse statusResponse = new PaymentStatusResponse();
        statusResponse.setOrderId(paymentEntity.getOrderId());
        statusResponse.setStatus(paymentEntity.getStatus());

        return statusResponse;
    }

    public void handleAlipayCallback(Map<String, String> params) {
        // 处理支付宝回调逻辑
    }

    public void handleWeChatPayCallback(Map<String, String> params) {
        // 处理微信支付回调逻辑
    }
}
