package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
