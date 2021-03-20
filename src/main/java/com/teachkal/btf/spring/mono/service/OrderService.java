package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
    boolean deleteById(Long id);
    Order update(Order order, Long id);
}
