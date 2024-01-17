package com.example.msaProductCreate.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer brandIdx;
    private String brandName;
    private String productName;
    private Integer quantity;
    private Integer price;
    private String image;

    //detail


}

