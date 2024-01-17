package com.example.lonua.coupon.model.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCouponListRes {
    private Integer couponIdx;
    private String couponName;

    @Range(min = 5,max= 100)
    @ApiModelProperty(value = "발급할 쿠폰의 할인율", example = "50", required = true)
    private Integer couponDiscountRate;
    private String receivedDate;
    private String couponExpirationDate;
    private Boolean status;
    private Integer userIdx;
}
