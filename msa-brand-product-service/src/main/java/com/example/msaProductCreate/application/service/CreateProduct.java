package com.example.msaProductCreate.application.service;


import com.common.Usecase;
import com.example.msaProductCreate.application.port.in.CreateProductCommand;
import com.example.msaProductCreate.application.port.in.CreateProductInport;
import com.example.msaProductCreate.application.port.out.ProductCreateOutPort;
import com.example.msaProductCreate.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProduct implements CreateProductInport {
    private final ProductCreateOutPort productCreateOutPort;
    @Override
    public Boolean create(CreateProductCommand createProductCommand) {
        return productCreateOutPort.create(Product.builder()
                        .brandIdx(createProductCommand.getBrandIdx())
                        .brandName(createProductCommand.getBrandName())
                        .image(createProductCommand.getImage())
                        .price(createProductCommand.getPrice())
                        .productName(createProductCommand.getProductName())
                        .quantity(createProductCommand.getQuantity())
                .build());

    }
}
