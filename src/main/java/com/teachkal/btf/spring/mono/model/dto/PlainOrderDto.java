package com.teachkal.btf.spring.mono.model.dto;

import com.teachkal.btf.spring.mono.model.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PlainOrderDto {

    private Long id;
    private String uid;
    private BigDecimal totalPrice;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static PlainOrderDto from(Order order) {
        PlainOrderDto plainOrderDto = new PlainOrderDto();
        plainOrderDto.setId(order.getId());
        plainOrderDto.setUid(order.getUid());
        plainOrderDto.setTotalPrice(order.getTotalPrice());
        plainOrderDto.setCreateAt(order.getCreatedAt());

        return plainOrderDto;
    }
}
