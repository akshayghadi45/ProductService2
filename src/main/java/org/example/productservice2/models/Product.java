package org.example.productservice2.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends Basemodel{
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;

}
