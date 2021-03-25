package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Order;
import com.teachkal.btf.spring.mono.model.dto.OrderDto;
import com.teachkal.btf.spring.mono.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody final OrderDto orderDto){
        Order order = orderService.addOrder(Order.from(orderDto));
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    List<Order> findAll(){
        return orderService.getOrders();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Order findById(@PathVariable long id){
        return orderService.getOrder(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody Order deleteById(@PathVariable long id){
        return orderService.deleteOrder(id);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody Order edit(@RequestBody Order order, @PathVariable long id){
        return orderService.editOrder(order, id);
    }

}

