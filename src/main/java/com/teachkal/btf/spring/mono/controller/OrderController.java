package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.entity.Order;
import com.teachkal.btf.spring.mono.model.dto.OrderDto;
import com.teachkal.btf.spring.mono.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody final OrderDto orderDto) {
        Order order = orderService.addOrder(Order.from(orderDto));
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<Order> orders = orderService.getOrders();
        List<OrderDto> ordersDto = orders.stream().map(OrderDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long id) {
        Order order = orderService.getOrder(id);
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable long id) {
        Order order = orderService.deleteOrder(id);
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OrderDto> editOrder(@RequestBody OrderDto orderDto, @PathVariable long id) {
        Order order = orderService.editOrder(Order.from(orderDto), id);
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.OK);
    }

}

