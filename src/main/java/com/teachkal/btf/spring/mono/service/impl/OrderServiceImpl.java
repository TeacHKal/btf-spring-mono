package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.Order;
import com.teachkal.btf.spring.mono.repository.OrderRepository;
import com.teachkal.btf.spring.mono.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.orderRepository = repository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Order update(Order order, Long id) {
        order.setId(id);
        return orderRepository.save(order);
    }
}
