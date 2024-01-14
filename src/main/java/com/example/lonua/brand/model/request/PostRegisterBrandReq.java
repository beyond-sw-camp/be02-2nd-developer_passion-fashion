package com.example.lonua.brand.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRegisterBrandReq {

//    private List<Branch> branchList = new ArrayList<>();
//    private List<Product> productList = new ArrayList<>();
    @NotNull
    @Length(max = 45)
    @ApiModelProperty(value = "판매자 이름", example = "농심", required = true)
    private String brandName;

    @NotNull
    @Length(max = 200)
    @ApiModelProperty(value = "판매자 설명", example = "신라면 파는 곳", required = true)
    private String brandIntroduction;

    @NotNull
    @ApiModelProperty(value = "판매자 사진", required = true)
    private MultipartFile brandImage;

    @NotNull
    @Length(max = 15)
    @ApiModelProperty(value = "판매자 스타일", example = "매운거", required = true)
    private String brandStyle;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "판매자 사업지 주소", example = "서울시", required = true)
    private String businessAddress;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "판매자 사업지 전화 번호", example = "02-123-4567", required = true)
    private String phoneNumber;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "사업자 등록증?", example = "사업자 등록증", required = true)
    private String businessRegistration;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "은행 계좌번호", example = "1233456789", required = true)
    private String bankAccountNumber;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "반송 주소", example = "서울시 창고로 123", required = true)
    private String returnAddress;

    @NotNull
    @Range(min = 0,max = 10000)
    @ApiModelProperty(value = "반송 가격", example = "서울시 창고로 123", required = true)
    private Integer returnCost;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "반송 담당 회사", example = "퀵", required = true)
    private String returnCourier;

}
