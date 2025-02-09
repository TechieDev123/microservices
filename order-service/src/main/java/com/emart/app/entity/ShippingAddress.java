package com.emart.app.entity;

import lombok.Data;

@Data
public class ShippingAddress {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
