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
    private Integer quantity;
    private Integer price;
    private String image;

    //detail


}

