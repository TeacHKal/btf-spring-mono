package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem addOrderItem(OrderItem orderItem);
    OrderItem getOrderItem(Long id);
    List<OrderItem> getOrderItems();
    OrderItem editOrderItem(OrderItem orderItem, Long id);
    OrderItem deleteOrderItem(Long id);

}
