package com.kinman.paydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kinman.paydemo.model.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<PaymentEntity> {
}
