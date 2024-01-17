package com.example.msaProductList.application.port.in;

import com.example.msaProductList.domain.Product;

import java.util.List;

public interface ListProductInPort {
    List<Product> list(Integer page, Integer size);
}
