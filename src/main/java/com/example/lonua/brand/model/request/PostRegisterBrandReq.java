package com.example.lonua.brand.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
<<<<<<< HEAD
import org.hibernate.validator.constraints.Range;
=======
>>>>>>> develop
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRegisterBrandReq {

<<<<<<< HEAD
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
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$") //TODO 정규표현 식 입력해야함.
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
    @ApiModelProperty(value = "반송 가격", example = "10000", required = true)
    private Integer returnCost;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "반송 담당 회사", example = "퀵", required = true)
=======
    @NotNull
    @Length(min=1, max=45)
    @ApiModelProperty(value = "브랜드명(45자 이하)", example = "SPAO", required = true)
    private String brandName;

    @NotNull
    @Length(min=1, max=500)
    @ApiModelProperty(value = "브랜드 소개글(500자 이하)", example = "스파오는 좋은 소재와 기본에 충실하면서도 트렌디한 디자인으로 남녀노소 누구나 일상 속에서 편안하게 입을 수 있는 패션 라이프를 제안하는 국내 최초 글로벌 SPA 브랜드입니다.", required = true)
    private String brandIntroduction;

    @NotNull
    @Length(max=10)
    @Pattern(regexp = "^(.*)$")
    @ApiModelProperty(value = "브랜드 스타일", example = "스포츠", required = true)
    private String brandStyle;

    @NotNull
    @Length(min=10, max=200)
    @ApiModelProperty(value = "사업자 주소 (도로명 주소)", example = "서울특별시 금천구 가산디지털1로 159 (가산동) 이랜드 가산동 사옥", required = true)
    private String businessAddress;

    @NotNull
    @Length(min = 1, max = 20)
    @ApiModelProperty(value = "사업자 전화번호", example = "1670-9700", required = true)
    private String phoneNumber;

    @NotNull
    @Length(min = 1, max = 10)
    @Pattern(regexp = "^[1-9]\\d{9}$")
    @ApiModelProperty(value = "사업자 등록증 번호", example = "1138519030", required = true)
    private String businessRegistration;

    @NotNull
    @Length(min = 1, max = 45)
    @ApiModelProperty(value = "계좌 번호", example = "111-1111-1111", required = true)
    private String bankAccountNumber;

    @NotNull
    @Length(min = 1, max = 200)
    @ApiModelProperty(value = "반품 주소", example = "(31214) 충청남도 천안시 동남구 풍세산단3로 111 이랜드패션통합물류센터 4F 스파오", required = true)
    private String returnAddress;

    @NotNull
    @Min(1)
    @ApiModelProperty(value = "반품 비용", example = "6000", required = true)
    private Integer returnCost;

    @NotNull
    @Length(min = 1, max = 45)
    @ApiModelProperty(value = "반품 택배사", example = "CJ대한통운", required = true)
>>>>>>> develop
    private String returnCourier;

}
