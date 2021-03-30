package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.OrderItem;
import com.teachkal.btf.spring.mono.model.dto.OrderItemDto;
import com.teachkal.btf.spring.mono.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping()
    public ResponseEntity<OrderItemDto> addOrderItem(@RequestBody OrderItemDto orderItemDto){
        OrderItem orderItem = orderItemService.addOrderItem(OrderItem.from(orderItemDto));
        return new ResponseEntity<>(OrderItemDto.from(orderItem), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<OrderItemDto>> getOrderItems(){
        List<OrderItem> orderItems = orderItemService.getOrderItems();
        List<OrderItemDto> orderItemDtos = orderItems.stream().map(OrderItemDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(orderItemDtos, HttpStatus.OK);
    }


}
