package com.emart.app.producer;

import com.emart.app.OrderProcessBo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessProducer {
    @Autowired
    private KafkaProducer<String, OrderProcessBo> kafkaProducer;

    public void publish(OrderProcessBo orderProcessBo) {
        ProducerRecord<String, OrderProcessBo> producerRecord = new ProducerRecord<>("Order-Process-Topic", orderProcessBo);
        kafkaProducer.send(producerRecord);
        kafkaProducer.flush();
    }
}
