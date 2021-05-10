package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.entity.Product;
import com.teachkal.btf.spring.mono.model.exception.ProductNotFoundException;
import com.teachkal.btf.spring.mono.repository.ProductRepository;
import com.teachkal.btf.spring.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException(id)
        );
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        product.setId(id);
        return productRepository.save(product);
    }
}
