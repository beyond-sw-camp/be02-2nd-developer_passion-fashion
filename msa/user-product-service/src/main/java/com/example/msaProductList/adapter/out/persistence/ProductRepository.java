package com.example.msaProductList.adapter.out.persistence;

import com.example.msaProductList.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    public Optional<ProductEntity> findByProductName(String productName);

    public Optional<ProductEntity> findByProductIdx(Integer productIdx);

    public Integer deleteByProductIdx(Integer idx);





}
