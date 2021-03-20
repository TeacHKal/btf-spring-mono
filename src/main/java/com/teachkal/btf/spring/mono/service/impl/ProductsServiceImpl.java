package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.repository.ProductsRepository;
import com.teachkal.btf.spring.mono.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productsRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        productsRepository.deleteById(id);
        return true;
    }

    @Override
    public Product update(Product product, Long id) {
        product.setId(id);
        return productsRepository.save(product);
    }
}
