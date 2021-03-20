package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.repository.ProductRepository;
import com.teachkal.btf.spring.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product update(Product product, Long id) {
        product.setId(id);
        return productRepository.save(product);
    }
}
