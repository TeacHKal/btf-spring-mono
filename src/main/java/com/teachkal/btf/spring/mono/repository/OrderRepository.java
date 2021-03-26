package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findByUid(String uid);
}
