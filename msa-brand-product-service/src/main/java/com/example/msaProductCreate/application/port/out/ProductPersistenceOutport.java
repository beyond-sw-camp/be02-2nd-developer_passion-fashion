package com.example.msaProductCreate.application.port.out;



import com.example.msaProductCreate.domain.Product;

import java.util.List;

public interface ProductPersistenceOutport {
    List<Product> list(Integer page, Integer size);
}
