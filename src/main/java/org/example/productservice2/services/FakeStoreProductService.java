package org.example.productservice2.services;

import org.example.productservice2.dtos.FakeStoreProductResposeDto;
import org.example.productservice2.exceptions.ProductNotFoundException;
import org.example.productservice2.models.Category;
import org.example.productservice2.models.Product;
import org.springframework.boot.web.client.RestTemplateRequestCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{



    //RestTemplate restTemplate = new RestTemplate(); instead of creating object using new we should inject the object using constructor
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getProducts() {

        List<Product> products = restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
        return List.of();
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        FakeStoreProductResposeDto fakeStoreProductResposeDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductResposeDto.class);
        if(fakeStoreProductResposeDto!=null){
            return fakeStoreResposeDtoToProduct(fakeStoreProductResposeDto);
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    public Product fakeStoreResposeDtoToProduct(FakeStoreProductResposeDto fakeStoreProductResposeDto) {
        Product product = new Product();
        product.setTitle(fakeStoreProductResposeDto.getTitle());
        product.setDescription(fakeStoreProductResposeDto.getDescription());
        product.setPrice(fakeStoreProductResposeDto.getPrice());
        product.setImage(fakeStoreProductResposeDto.getImage());
        Category category = new Category();
        category.setValue(fakeStoreProductResposeDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
