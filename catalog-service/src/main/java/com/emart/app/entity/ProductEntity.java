package com.emart.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "products")
public class ProductEntity {
    @Indexed(unique = true)
    private int uid;
    @MongoId
    private String sku;
    private String name;
    private String description;
    private float unitPrice;
    private int availableQuantity;
    private String category;
    private String imageUrl;
    private float discountedPrice;
    private String catalogName;
    private String tags;
    private float ratings;
    private float reviews;
    private float noOfRatings;
}
