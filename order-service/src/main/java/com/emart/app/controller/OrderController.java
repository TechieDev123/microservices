package com.emart.app.controller;

import com.emart.app.bo.OrderBo;
import com.emart.app.repo.OrderRepository;
import com.emart.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String placeOrder(@RequestBody OrderBo orderBo) {
        return orderService.addOrder(orderBo);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderBo> getAllOrdersBySessionId(String sessionId) {
        return null;
    }
}
