package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 16:48
 * @Params PaymentMapper
 */
@Mapper
@Repository
public interface PaymentMapper extends BaseMapper<Payment> {
}
