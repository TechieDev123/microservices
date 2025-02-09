package com.emart.app.service;

import com.emart.app.OrderProcessBo;
import com.emart.app.bo.OrderBo;
import com.emart.app.bo.ProductBo;
import com.emart.app.entity.Order;
import com.emart.app.model.CustomerModel;
import com.emart.app.model.ProductModel;
import com.emart.app.producer.OrderProcessProducer;
import com.emart.app.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderProcessProducer orderProcessProducer;

    @Transactional
    public String addOrder(OrderBo orderBo) {
        Order orderEntity = new Order();
        String orderNo = UUID.randomUUID().toString();
        orderEntity.setOrderNo(orderNo);
        orderEntity.setOrderStatus("ORDERED");

        CustomerModel customerModel = getCustomer(orderBo.getPhoneNumber());
        orderEntity.setCustomer(customerModel);

        List<ProductModel> productModelList = new ArrayList<>();
        for (ProductBo productBo : orderBo.getProductBos()) {
            String sku = productBo.getSku();
            ProductModel productModel = getProduct(sku);
            productModelList.add(productModel);
        }
        orderEntity.setProducts(productModelList);

        orderRepository.save(orderEntity);

        OrderProcessBo orderProcessBo=new OrderProcessBo();
        orderProcessBo.setOrderStatus(orderEntity.getOrderStatus());
        orderProcessBo.setOrderNo(orderNo);
        orderProcessProducer.publish(orderProcessBo);
        return orderNo;
    }

    public CustomerModel getCustomer(String phoneNumber) {
        String customerUrl = "http://localhost:8080/customer/" + phoneNumber;
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json");
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<CustomerModel> responseEntity = restTemplate.exchange(customerUrl, HttpMethod.GET, httpEntity, CustomerModel.class);
        if (responseEntity.getStatusCode().value() == 200) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Customer service error");
        }
    }

    public ProductModel getProduct(String sku) {
        String productUrl = "http://localhost:8081/product/" + sku;
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json");
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<ProductModel> responseEntity = restTemplate.exchange(productUrl, HttpMethod.GET, httpEntity, ProductModel.class);
        if (responseEntity.getStatusCode().value() == 200) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("product service error");
        }
    }
}
