package com.emart.app.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String sku;
    private String name;
    private String description;
    private float price;
    private float quantity;
    private float total;
}
