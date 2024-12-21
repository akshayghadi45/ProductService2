package org.example.productservice2.controllers;

import org.example.productservice2.exceptions.ProductNotFoundException;
import org.example.productservice2.models.Product;
import org.example.productservice2.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductsControllerTest {
    @Autowired
    private ProductsController controller;

    @MockitoBean
    private ProductService service;

    @Autowired
    private ProductService productService;

    @Test
    void getSingleProductTest() throws ProductNotFoundException {
        //Arrage
        Product expectedProduct = new Product();
        expectedProduct.setTitle("iphone 15 pro");
        expectedProduct.setDescription("Apple");
        expectedProduct.setPrice(10000.0);

        //Mocking the getSingleProduct method of productService
        when(productService.getProduct(10L)).
                thenReturn(expectedProduct);

        //Act

        Product actualProduct = controller.getSingleProduct(10L);

        //Assert
        assertEquals(expectedProduct, actualProduct);


    }

    @Test
    void getAllProductsTest() {

        //Arrange
        Product product1 = new Product();
        product1.setTitle("iphone 15 pro");
        product1.setDescription("Apple");
        product1.setPrice(10000.0);

        Product product2 = new Product();
        product2.setTitle("iphone 14 pro");
        product2.setDescription("Apple");
        product2.setPrice(10000.0);

        Product product3 = new Product();
        product3.setTitle("iphone 13 pro");
        product3.setDescription("Apple");
        product3.setPrice(10000.0);

        List<Product> ExpectedProducts = List.of(product1, product2, product3);

        //Mocking
        when(productService.getProducts()).
                thenReturn(ExpectedProducts);

        //Act
        List<Product> actualProducts = controller.getAllProducts();

        //Assert
        assertEquals(ExpectedProducts.size(), actualProducts.size());


    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }
}