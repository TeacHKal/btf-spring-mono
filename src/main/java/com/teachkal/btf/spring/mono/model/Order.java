package com.teachkal.btf.spring.mono.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teachkal.btf.spring.mono.config.AppSettings;
import com.teachkal.btf.spring.mono.model.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "uid", nullable = false)
    private String uid;
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    //@JsonManagedReference
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id",
            foreignKey=@ForeignKey(name = "FK__orders__order_items")
    )
    private List<OrderItem> orderItems;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "created_at", insertable = false, updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createdAt;

    public static Order from(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setUid(orderDto.getUid());
        order.setTotalPrice(orderDto.getTotalPrice());

        return order;
    }

}
