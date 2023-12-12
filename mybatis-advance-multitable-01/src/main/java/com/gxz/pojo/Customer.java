package com.gxz.pojo;

import java.util.List;

public class Customer {
    private Integer customerId;
    private String customerName;
    //对多查询，生成目标类的集合对象
    private List<Order> orderList;

    public List<Order> getOrder() {
        return orderList;
    }

    public void setOrder(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customerId = customer_id;
    }

    public String getCustomer_name() {
        return customerName;
    }

    public void setCustomer_name(String customer_name) {
        this.customerName = customer_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
