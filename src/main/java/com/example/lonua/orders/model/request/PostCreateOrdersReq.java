package com.example.lonua.orders.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotNull;
>>>>>>> develop
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCreateOrdersReq {

<<<<<<< HEAD
    @Min(value = 1)
    @ApiModelProperty(value = "주문 수량", example = "1", required = true)
    private Integer amount;

    @Pattern(regexp = "^[imp]") //imp로 시작하는 문자열
    @ApiModelProperty(value = "아임포트 결제 API, 결제 번호", example = "1", required = true)
    private String impUid;

    @ApiModelProperty(value = "아임포트 결제 API,상인(판매자...?) 번호", example = "1", required = true)
    private String merchantUid;

    @Length(max = 50)
    @ApiModelProperty(value = "상품이름", example = "신라면 5개입 외 2개", required = true)
    private String productName; // 이것도 리스트 여야할 듯...?

    @Length(max = 50)
    @ApiModelProperty(value = "결제 방법", example = "설거지", required = true)
    private String payMethod;

    @Length(max = 50)
    @ApiModelProperty(value = "구매한 상품들의 id", example = "[1,2,3]", required = true)
=======
    @NotNull
    @Min(1)
    @ApiModelProperty(value = "총 주문 금액", example = "50000", required = true)
    private Integer amount;

    @NotNull
    @Pattern(regexp = "^imp_\\d{12}$")
    @ApiModelProperty(value = "결제 번호", example = "imp_581455476041", required = true)
    private String impUid;

    @NotNull
    @Length(min=1, max=18)
    @ApiModelProperty(value = "주문 번호", example = "202401062125264623", required = true)
    private String merchantUid;

    @NotNull
    @Length(max=45)
    @ApiModelProperty(value = "상품명(45자 이하)", example = "하프 집업 카라넥 케이블 니트 [카키]", required = true)
    private String productName;

    @NotNull
    @Length(min=1)
    @ApiModelProperty(value = "결제 수단", example = "카카오페이", required = true)
    private String payMethod;

    @NotNull
    @ApiModelProperty(value = "주문 상품 리스트", example = "[1, 2, 3]", required = true)
>>>>>>> develop
    private List<Integer> productIdxList;

}
