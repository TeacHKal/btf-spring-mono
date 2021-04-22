package com.teachkal.btf.spring.mono.model.dto;

import com.teachkal.btf.spring.mono.model.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class OrderItemDto {

    private Long id;
    private Long order_id;
    private Long product_id;
    private Long quantity;
    private BigDecimal unitPrice;
    private LocalDateTime createdAt;
    private PlainOrderDto plainOrderDto;

    public static OrderItemDto from(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId(orderItem.getId());
        orderItemDto.setOrder_id(orderItem.getOrderId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setUnitPrice(orderItem.getUnitPrice());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());
        orderItemDto.setProduct_id(orderItem.getProductId());
        if(Objects.nonNull(orderItem.getOrder())){
            orderItemDto.setPlainOrderDto(PlainOrderDto.from(orderItem.getOrder()));
        }

        return orderItemDto;
    }
}
