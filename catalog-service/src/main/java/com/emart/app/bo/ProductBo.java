package com.emart.app.bo;

import lombok.Data;

@Data
public class ProductBo {
    private int uid;
    private String sku;
    private String name;
    private String description;
    private float unitPrice;
    private int availableQuantity;
    private String category;
    private String imageUrl;
    private float discountedPrice;
    private String tags;
    private float ratings;
    private float reviews;
    private float noOfRatings;
}
