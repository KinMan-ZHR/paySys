package com.kinman.paydemo.controller;

import com.kinman.paydemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment/callback")
public class PaymentCallbackController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/alipay")
    public ResponseEntity<String> alipayCallback(@RequestBody Map<String, String> params) {
        // 处理支付宝回调
        paymentService.handleAlipayCallback(params);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/wechatpay")
    public ResponseEntity<String> wechatpayCallback(@RequestBody Map<String, String> params) {
        // 处理微信支付回调
        paymentService.handleWeChatPayCallback(params);
        return ResponseEntity.ok("Success");
    }
}
