package com.emart.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "session")
public class SessionEntity {
    @MongoId
    private String sessionId;
    private String sessionState;
    private String customerId;
    private List<String> cart;
}
