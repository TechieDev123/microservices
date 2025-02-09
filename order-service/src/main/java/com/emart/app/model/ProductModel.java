package com.emart.app.model;

import lombok.Data;

@Data
public class ProductModel {
    private int id;
    private String sku;
    private String name;
    private String description;
    private float unitPrice;
    private int availableQuantity;
    private String category;
    private String imageUrl;
    private float discountedPrice;
    private String tags;
}
