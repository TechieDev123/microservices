package com.emart.app.respository;

import com.emart.app.entity.CatalogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<CatalogEntity, Integer> {
    CatalogEntity findByName(String name);
}
