package com.gxz.pojo;

public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;
    //存储对应的客户信息，用于多表查询
    private Customer customer;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customerId = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customerId=" + customerId +
                ", customer=" + customer +
                '}';
    }
}
