package com.example.lonua.product.model.request;


import com.example.lonua.product.model.response.GetProductIntrodRes;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRegisterProductReq {
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "판매자 ID(1이상의 숫자)", example = "1", required = true)
    private Integer brand_idx;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "카테고리 ID(1이상의 숫자)", example = "1", required = true)
    private Integer category_idx;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "스타일 ID(1이상의 숫자)", example = "1", required = true)
    private Integer style_idx;

    @NotNull
    @Length(max=45)
    @ApiModelProperty(value = "상품명(45자 이하)", example = "멋진 후드티", required = true)
    private String productName;

    @NotNull
    @Pattern(regexp = ".*\\\\.(jpg|jpeg|png|gif|bmp)$",message = "이미지 파일 확장자")
    @ApiModelProperty(value = "상품 이미지(파일 첨부)", required = true)
    private MultipartFile productImage;

    @NotNull
    @Length(max=45)
    @ApiModelProperty(value = "상품 설명 이미지(파일 첨부)", required = true)
    private MultipartFile productIntroductionImage;

    @NotNull
    //@Length(max=45)
    @Min(value = 0)
    @ApiModelProperty(value = "수량", example = "1", required = true)
    private Integer quantity;

    @NotNull
    @Range(min = 100,max = 400000000) // 4억 이하로만 해주세요.
    @ApiModelProperty(value = "가격", example = "1000", required = true)
    private Integer price;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "제품의 어깨 사이즈", example = "15.0", required = true)
    private Float shoulderWidth;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "제품의 가슴 사이즈", example = "15.0", required = true)
    private Float chestSize;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "제품의 팔 길이", example = "15.0", required = true)
    private Float armLength;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "제품의 전체 길이", example = "15.0", required = true)
    private Float topLength;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "제품의 허리 둘레 길이", example = "15.0", required = true)
    private Float waistline;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "제품의 엉덩이 둘레 길리", example = "15.0", required = true)
    private Float hipCircumference;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "밑 단 길리", example = "15.0", required = true)
    private Float thighCircumference;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "가랑이 길이", example = "15.0", required = true)
    private Float crotchLength;

    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "허벅지 둘레", example = "15.0", required = true)
    private Float hemLength;


    @NotNull
    @Positive // 0 이상의 양수
    @ApiModelProperty(value = "하체 길이", example = "15.0", required = true)
    private Float totalBottomLength;
}
