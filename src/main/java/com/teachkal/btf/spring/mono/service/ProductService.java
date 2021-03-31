package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getProducts();
    Product getProduct(Long id);
    Product deleteProduct(Long id);
    Product updateProduct(Product product, Long id);

}
