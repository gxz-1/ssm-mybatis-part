package com.gxz.mapper;

import com.gxz.pojo.Order;

import java.util.List;

//对多的多表查询，查询客户的所有订单Order信息
public interface CustomerMapper {
    List<Order> QueryAllOrder();
}
