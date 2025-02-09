package com.emart.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "catalog")
public class CatalogEntity {
    @MongoId
    private int uid;
    private String name;
    private String description;
    private String tags;
}
