package com.emart.app.bo;

import lombok.Data;

@Data
public class CartItemBo {
    private String name;
    private float unitPrice;
    private int quantity;
    private String imageUrl;
}
