package com.example.msaProductList.application.service;

import com.common.Usecase;
import com.example.msaProductList.application.port.in.CreateProductCommand;
import com.example.msaProductList.application.port.in.CreateProductInport;
import com.example.msaProductList.application.port.out.ProductPersistenceOutport;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class CreateProduct implements CreateProductInport {
    private final ProductPersistenceOutport productPersistenceOutport;
    @Override
    public void create(CreateProductCommand createProductCommand) {
        productPersistenceOutport.create(createProductCommand);
    }
}
