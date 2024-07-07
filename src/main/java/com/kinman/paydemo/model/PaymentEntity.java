package com.kinman.paydemo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("payment")
public class PaymentEntity {
    @TableId
    private String orderId;
    private String status;
    private double amount;
    private String paymentMethod;
}

