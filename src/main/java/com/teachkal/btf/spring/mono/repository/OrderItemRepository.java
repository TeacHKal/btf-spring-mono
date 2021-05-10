package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
