package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.Order;
import java.util.List;

public interface OrderService {

    Order addOrder(Order order);
    List<Order> getOrders();
    Order getOrder(Long id);
    Order editOrder(Order order, Long id);
    Order deleteOrder(Long id);
}
