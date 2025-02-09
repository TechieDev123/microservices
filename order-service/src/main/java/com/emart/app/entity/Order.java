package com.emart.app.entity;

import com.emart.app.model.CustomerModel;
import com.emart.app.model.ProductModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @MongoId
    private String orderNo;
    //private String orderedDate;

    /*private String orderAmount;
    private String paymentMethod;
    private String paymentReferenceNumber;*/
    private CustomerModel customer;
    private List<ProductModel> products;
    private String orderStatus;
}
