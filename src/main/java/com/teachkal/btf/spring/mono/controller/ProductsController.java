package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping(path = "")
    public @ResponseBody
    Product save(@RequestBody Product product){
        return productsService.save(product);
    }

    @GetMapping(path = "")
    public @ResponseBody List<Product> findAll(){
        return productsService.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Product> findById(@PathVariable long id){
        return productsService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody boolean deleteById(@PathVariable long id){
        productsService.deleteById(id);
        return true;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    Product edit(@RequestBody Product product, @PathVariable long id){
        product.setId(id);
        return productsService.save(product);
    }

}
