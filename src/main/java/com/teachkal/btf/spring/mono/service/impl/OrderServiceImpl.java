package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.Order;
import com.teachkal.btf.spring.mono.model.exception.OrderDuplicateUidException;
import com.teachkal.btf.spring.mono.model.exception.OrderNotFoundException;
import com.teachkal.btf.spring.mono.repository.OrderRepository;
import com.teachkal.btf.spring.mono.service.OrderService;
import com.teachkal.btf.spring.mono.shared.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.orderRepository = repository;
    }

    @Override
    public Order addOrder(Order order) {
        checkForDuplicateUid(order);
        return orderRepository.save(order);

    }

    @Override
    public List<Order> getOrders() {
        return Util.iterableToList(orderRepository.findAll());
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException(id));
    }

    @Override
    public Order deleteOrder(Long id) {
        Order order = getOrder(id);
        orderRepository.delete(order);
        return order;
    }

    @Override
    public Order editOrder(Order order, Long id) {
        checkForDuplicateUid(order);

        Order orderToEdit = getOrder(id);
        orderToEdit.setUid(order.getUid());
        orderToEdit.setTotalPrice(order.getTotalPrice());
        return orderToEdit;
    }

    public void checkForDuplicateUid(Order order){
        if(orderRepository.findByUid(order.getUid()).isPresent()){
            throw new OrderDuplicateUidException(order.getUid());
        }
    }
}
