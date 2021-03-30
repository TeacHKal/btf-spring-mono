package com.teachkal.btf.spring.mono.model.dto;

import com.teachkal.btf.spring.mono.model.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemDto {

    private Long id;
    private Long order_id;
    private Long product_id;
    private Long quantity;
    private BigDecimal unitPrice;
    private LocalDateTime createdAt;
    private Order order;

}
