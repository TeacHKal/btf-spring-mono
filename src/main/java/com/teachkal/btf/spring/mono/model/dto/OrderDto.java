package com.teachkal.btf.spring.mono.model.dto;

import com.teachkal.btf.spring.mono.model.Order;
import com.teachkal.btf.spring.mono.model.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDto {
    private Long id;
    private String uid;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItemDto> orderItemsDto;

    public static OrderDto from(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUid(order.getUid());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setCreatedAt(order.getCreatedAt());
        orderDto.setUpdatedAt(order.getUpdatedAt());
        orderDto.setOrderItemsDto(order.getOrderItems().stream().map(OrderItemDto::from).collect(Collectors.toList()));

        return orderDto;
    }
}
