package com.example.msaProductList.adapter.out.persistence;

import com.common.ExtenalSystemAdapter;
import com.example.msaProductList.adapter.in.web.BaseRes;
import com.example.msaProductList.adapter.out.persistence.entity.ProductEntity;
import com.example.msaProductList.adapter.out.persistence.entity.ProductImageEntity;
import com.example.msaProductList.application.port.out.ProductPersistenceOutport;
import com.example.msaProductList.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
@ExtenalSystemAdapter
@RequiredArgsConstructor
public class PersistenceAdapter implements ProductPersistenceOutport {
    private final ProductRepository productRepository;
    public List<Product> list(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> productEntityPage = productRepository.findAll(pageable);
        List<Product> productList = new ArrayList<>();
        for(ProductEntity entity : productEntityPage.getContent()) {
            List<ProductImageEntity> productImageList = entity.getProductImageList();
            ProductImageEntity productImage = productImageList.get(0);
            String image = productImage.getProductImage();
            // 상품의 이미지중 첫번 째 이미지만 뽑아옴
            Product product = Product.builder()
                    //.brandName(product.getBrand().getBrandName())
                    .productIdx(entity.getProductIdx())
                    .productName(entity.getProductName())
                    .image(image)
                    .price(entity.getPrice())
                    //.likeCount(entity.getProductCount().getLikeCount())
                    .build();

            productList.add(product);
        }

        return productList;
    }
}
