package org.example.productservice2.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class FakeStoreProductResposeDto {
    private int id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
