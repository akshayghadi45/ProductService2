package org.example.productservice2.services;

import org.example.productservice2.exceptions.ProductNotFoundException;
import org.example.productservice2.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getProducts();
    public Product getProduct(Long id) throws ProductNotFoundException;
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);

}
