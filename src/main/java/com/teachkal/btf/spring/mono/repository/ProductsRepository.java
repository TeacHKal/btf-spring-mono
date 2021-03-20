package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductsRepository extends CrudRepository<Product, Long> {

}
