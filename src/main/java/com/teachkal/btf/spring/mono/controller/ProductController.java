package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "")
    public @ResponseBody
    Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping(path = "")
    public @ResponseBody List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Product> findById(@PathVariable long id){
        return productService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody boolean deleteById(@PathVariable long id){
        productService.deleteById(id);
        return true;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    Product edit(@RequestBody Product product, @PathVariable long id){
        return productService.save(product);
    }

}
