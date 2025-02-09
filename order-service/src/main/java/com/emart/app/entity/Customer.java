package com.emart.app.entity;

import lombok.Data;

@Data
public class Customer {
    private String customerName;
    private String phoneNumber;
    private String addressType;
    private ShippingAddress shippingAddress;
}
