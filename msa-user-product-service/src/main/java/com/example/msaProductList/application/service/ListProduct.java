package com.example.msaProductList.application.service;

import com.common.Usecase;
import com.example.msaProductList.adapter.in.web.BaseRes;
import com.example.msaProductList.application.port.in.ListProductInPort;
import com.example.msaProductList.application.port.out.ProductPersistenceOutport;
import com.example.msaProductList.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Usecase
@RequiredArgsConstructor
public class ListProduct implements ListProductInPort {
    private final ProductPersistenceOutport productPersistenceOutport;

    @Override
    public List<Product> list(Integer page, Integer size) {
        return productPersistenceOutport.list(page,size);
    }
}
