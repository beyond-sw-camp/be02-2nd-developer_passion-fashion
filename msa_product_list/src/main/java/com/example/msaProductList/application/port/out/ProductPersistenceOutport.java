package com.example.msaProductList.application.port.out;

import com.example.msaProductList.domain.Product;

import java.util.List;

public interface ProductPersistenceOutport {
    List<Product> list(Integer page, Integer size);
}
