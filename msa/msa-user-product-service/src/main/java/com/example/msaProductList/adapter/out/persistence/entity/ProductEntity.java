package com.example.msaProductList.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productIdx;


    private Integer brandIdx;
    private String brandName;
    private Integer category;
    private String style;
    private Integer productCount;

    @Column(nullable = false, length = 45)
    private String productName;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer price;

    private String IntroImage;

    @Column(nullable = false)
    private Boolean status;

}
