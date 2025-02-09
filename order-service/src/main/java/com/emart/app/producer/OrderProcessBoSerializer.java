package com.emart.app.producer;

import com.emart.app.OrderProcessBo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class OrderProcessBoSerializer implements Serializer<OrderProcessBo> {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, OrderProcessBo orderProcessBo) {
        try {
            return mapper.writeValueAsBytes(orderProcessBo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        mapper = null;
    }
}
