package com.emart.app.service;

import com.emart.app.bo.CartItemBo;
import com.emart.app.bo.ProductBo;
import com.emart.app.bo.SessionBo;
import com.emart.app.entity.SessionEntity;
import com.emart.app.respository.SessionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionService {
    @Autowired
    private SessionRespository sessionRespository;

    @Autowired
    private ProductService productService;

    public void addSession(SessionBo sessionBo) {
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setSessionId(sessionBo.getSessionId());
        sessionEntity.setSessionState(sessionBo.getSessionState());
        sessionEntity.setCustomerId(sessionBo.getCustomerId());
        sessionRespository.save(sessionEntity);
    }

    public void addToCart(String sessionId, String sku) {
        Optional<SessionEntity> sessionEntityOptional = sessionRespository.findById(sessionId);
        if (sessionEntityOptional.isPresent()) {
            SessionEntity sessionEntity = sessionEntityOptional.get();
            if (sessionEntity.getCart() == null) {
                List<String> cartList = new ArrayList<>();
                cartList.add(sku);
                sessionEntity.setCart(cartList);
            } else {
                sessionEntity.getCart().add(sku);
            }
            sessionRespository.save(sessionEntity);
        }
    }

    public List<CartItemBo> getCartItems(String sessionId) {
        Optional<SessionEntity> sessionEntityOptional = sessionRespository.findById(sessionId);
        if (sessionEntityOptional.isPresent()) {
            SessionEntity sessionEntity = sessionEntityOptional.get();
            List<String> cartList = sessionEntity.getCart();
            if (cartList != null) {
                return cartList.stream().map(cart -> {
                    ProductBo productBo = productService.getProduct(cart);
                    CartItemBo cartItemBo = new CartItemBo();
                    cartItemBo.setName(productBo.getName());
                    cartItemBo.setQuantity(1);
                    cartItemBo.setImageUrl(productBo.getImageUrl());
                    cartItemBo.setUnitPrice(productBo.getUnitPrice());
                    return cartItemBo;
                }).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }
}
