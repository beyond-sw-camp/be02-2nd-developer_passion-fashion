package com.example.msaProductCreate.application.port.out;

import com.example.msaProductCreate.domain.Product;

public interface ProductCreateOutPort {
    public Boolean create(Product product);
}
