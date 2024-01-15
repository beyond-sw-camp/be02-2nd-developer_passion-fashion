package com.example.lonua.brand.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatchUpdateBrandReq {
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "수정할 판매자 idx", example = "1", required = true)
    private Integer brandIdx;

    @NotNull
    @Length(max = 45)
    @ApiModelProperty(value = "수정할 판매자의 이름 정보", example = "오뚜기", required = true)
    private String brandName;

    @Length(max = 200)
    @ApiModelProperty(value = "수정할 판매자의 소개글", example = "오뚜기 3분 요리파는 곳", required = true)
    private String brandIntroduction;

    //TODO 정해진 단어만 들어와야함.
    @ApiModelProperty(value = "수정할 판매자의 브랜드 스타일", example = "빈티지", required = true)
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
    @ApiModelProperty(value = "반송 가격", example = "10000", required = true,notes = "사용자가 반송 요청 시 받을 돈")
    private Integer returnCost;

    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "반송 담당 회사", example = "퀵", required = true)
    private String returnCourier;
}
