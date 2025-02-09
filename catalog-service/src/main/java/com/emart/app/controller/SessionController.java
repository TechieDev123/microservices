package com.emart.app.controller;

import com.emart.app.bo.CartItemBo;
import com.emart.app.bo.SessionBo;
import com.emart.app.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PutMapping(path = "{sessionId}/cart/{sku}")
    public void addToCart(@PathVariable("sessionId") String sessionId,@PathVariable("sku") String sku) {
        sessionService.addToCart(sessionId, sku);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String createSession(@RequestBody SessionBo sessionBo) {
        sessionService.addSession(sessionBo);
        return "session created";
    }

    @GetMapping(path = "/{sessionId}")
    public List<CartItemBo> cart(@PathVariable("sessionId") String sessionId) {
        return sessionService.getCartItems(sessionId);
    }
}
