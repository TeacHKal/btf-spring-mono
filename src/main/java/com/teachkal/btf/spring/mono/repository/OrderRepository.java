package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
