package com.example.msaProductList.adapter.out.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productIdx;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImageEntity> productImageList = new ArrayList<>();
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductIntrodImageEntity> productIntrodImageList = new ArrayList<>();

    private Integer brandIdx;
    private Integer category;
    private Integer style;
    private Integer productCount;

    @Column(nullable = false, length = 45)
    private String productName;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer price;
    private Float shoulderWidth; // 어깨 너비
    private Float chestSize;  // 가슴 둘레
    private Float armLength;  // 팔 길이
    private Float topLength;  // 상의 총 길이

    private Float waistline;  // 허리 둘레
    private Float hipCircumference;  // 엉덩이 둘레
    private Float thighCircumference;  // 허벅지 둘레
    private Float crotchLength;  // 밑위 길이
    private Float hemLength;  // 밑단 길이
    private Float totalBottomLength;  // 하의 총 길이

    private String createdAt;
    private String updatedAt;

    @Column(nullable = false)
    private Boolean status;

}
