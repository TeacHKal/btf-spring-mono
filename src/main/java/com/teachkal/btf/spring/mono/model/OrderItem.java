package com.teachkal.btf.spring.mono.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teachkal.btf.spring.mono.config.AppSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

   // @ManyToOne
    //private Order order;

}
