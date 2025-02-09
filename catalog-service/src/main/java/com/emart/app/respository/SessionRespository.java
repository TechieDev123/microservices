package com.emart.app.respository;

import com.emart.app.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRespository extends MongoRepository<SessionEntity,String> {
}
