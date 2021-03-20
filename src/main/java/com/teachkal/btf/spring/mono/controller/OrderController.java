package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Order;
import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.service.OrderService;
import com.teachkal.btf.spring.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "")
    public @ResponseBody
    Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Order> findById(@PathVariable long id){
        return orderService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody boolean deleteById(@PathVariable long id){
        orderService.deleteById(id);
        return true;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    Order edit(@RequestBody Order order, @PathVariable long id){
        return orderService.save(order);
    }

}

