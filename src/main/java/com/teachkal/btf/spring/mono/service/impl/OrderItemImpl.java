package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.entity.OrderItem;
import com.teachkal.btf.spring.mono.model.exception.OrderItemNotFoundException;
import com.teachkal.btf.spring.mono.repository.OrderItemRepository;
import com.teachkal.btf.spring.mono.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderItemImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() ->
                new OrderItemNotFoundException(id));
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return StreamSupport.stream(orderItemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItem editOrderItem(OrderItem orderItem, Long id) {
        OrderItem orderItemToEdit = getOrderItem(id);
        orderItemToEdit.setQuantity(orderItem.getQuantity());
        orderItemToEdit.setUnitPrice(orderItem.getUnitPrice());

        return orderItemToEdit;
    }

    @Override
    public OrderItem deleteOrderItem(Long id) {
        OrderItem orderItem = getOrderItem(id);
        orderItemRepository.delete(orderItem);
        return orderItem;
    }

}
