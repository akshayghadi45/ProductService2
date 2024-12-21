package org.example.productservice2.controllers;

import org.example.productservice2.exceptions.ProductNotFoundException;
import org.example.productservice2.models.Product;
import org.example.productservice2.services.FakeStoreProductService;
import org.example.productservice2.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products") //impo
public class ProductsController {
    ProductService productService;
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
//        return new ResponseEntity<>(
//                productService.getProduct(productId),
//                HttpStatus.OK
//        );

        return productService.getProduct(productId);


    }
    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getProducts();
    }
    @PostMapping
    public Product createProduct(Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product  ){

    }
}
