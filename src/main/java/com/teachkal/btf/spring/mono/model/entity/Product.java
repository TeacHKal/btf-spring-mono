package com.teachkal.btf.spring.mono.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teachkal.btf.spring.mono.config.AppSettings;
import com.teachkal.btf.spring.mono.model.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products",
        uniqueConstraints = {
            @UniqueConstraint(name = "product_sku_unique", columnNames = "sku")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long Id;
    @Column(name = "sku", length = 50, nullable = false)
    private String sku;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "description", nullable = false)
    private String description;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "created_at", insertable = false, updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createdAt;

    public static Product from(ProductDto productDto) {
        Product product = new Product();

        product.setId(productDto.getId());
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCreatedAt(productDto.getCreatedAt());

        return product;

    }
}


