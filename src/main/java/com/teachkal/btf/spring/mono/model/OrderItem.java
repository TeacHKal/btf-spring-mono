package com.teachkal.btf.spring.mono.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teachkal.btf.spring.mono.config.AppSettings;
import com.teachkal.btf.spring.mono.model.dto.OrderItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "order_id", insertable = false, updatable = false)
    private Long orderId;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    //@JsonBackReference
    @ManyToOne
    private Order order;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "created_at", insertable = false, updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "updated_at", insertable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;



    public static OrderItem from(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderItemDto.getOrder_id());
        orderItem.setUnitPrice(orderItemDto.getUnitPrice());
        orderItem.setQuantity(orderItemDto.getProduct_id());

        return orderItem;
    }
}
