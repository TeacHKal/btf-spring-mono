package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Product;
import com.teachkal.btf.spring.mono.model.dto.ProductDto;
import com.teachkal.btf.spring.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(Product.from(productDto));
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<Product> productList = productService.getProducts();
        List<ProductDto> productDtoList = productList.stream().map(ProductDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable long id){
        Product product = productService.deleteProduct(id);
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable long id){
        Product product = productService.updateProduct(Product.from(productDto), id);
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
    }

}
