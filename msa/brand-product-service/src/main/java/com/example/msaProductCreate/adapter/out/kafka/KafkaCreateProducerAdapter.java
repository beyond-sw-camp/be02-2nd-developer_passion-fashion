package com.example.msaProductCreate.adapter.out.kafka;

import com.common.ExtenalSystemAdapter;
import com.example.msaProductCreate.application.port.out.ProductCreateOutPort;
import com.example.msaProductCreate.domain.Product;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaCreateProducerAdapter implements ProductCreateOutPort {
    private final KafkaTemplate<String,Product> kafkaTemplate;

    @Override
    public Boolean create(Product product) {
        ProducerRecord<String,Product> record = new ProducerRecord<>("product-create","product", product);
        kafkaTemplate.send(record);
        return true;
    }
}
