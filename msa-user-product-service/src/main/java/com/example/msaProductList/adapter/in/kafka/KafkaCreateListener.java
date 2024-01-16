package com.example.msaProductList.adapter.in.kafka;

import com.common.ExtenalSystemAdapter;
import com.example.msaProductList.application.port.in.CreateProductCommand;
import com.example.msaProductList.application.port.in.CreateProductInport;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;


@ExtenalSystemAdapter
@RequiredArgsConstructor
public class KafkaCreateListener {
    private final CreateProductInport createProductInport;
    @KafkaListener(topics = "product-create", groupId = "product-create-group-00") //카프카 컨슈머 역활을 한다.
    void createEmailCert(ConsumerRecord<String,CreateProductCommand> record){

        System.out.println(record);
        //CreateProductCommand createProductCommand = record.value();
        System.out.println(record.value());
        createProductInport.create(CreateProductCommand.builder()
                        .brandIdx(record.value().getBrandIdx())
                        .brandName(record.value().getBrandName())
                        .productName(record.value().getProductName())
                        .price(record.value().getPrice())
                        .quantity(record.value().getQuantity())
                        .image(record.value().getImage())
                .build());

    }
}
