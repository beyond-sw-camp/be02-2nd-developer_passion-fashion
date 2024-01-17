package com.example.msaProductList.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productIdx;
    private String productName;
    private Integer brandIdx;
    private String brandName;
    private Integer quantity;
    private Integer price;
    private String image;

    //detail


}

