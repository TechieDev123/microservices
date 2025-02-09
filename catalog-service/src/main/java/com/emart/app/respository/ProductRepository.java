package com.emart.app.respository;

import com.emart.app.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity,String> {
    public List<ProductEntity> findByCatalogName(String name);
}
