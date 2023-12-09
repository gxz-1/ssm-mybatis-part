package com.gxz.mapper;

import com.gxz.pojo.Order;

//对单的多表查询，根据id查询订单Order信息和订单对应的唯一客户的信息
public interface OrderMapper {
    Order queryByOrderId(Integer orderId);
}
