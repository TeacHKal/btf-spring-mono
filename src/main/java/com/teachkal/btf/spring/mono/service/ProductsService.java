package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    boolean deleteById(Long id);
    Product update(Product product, Long id);

}
