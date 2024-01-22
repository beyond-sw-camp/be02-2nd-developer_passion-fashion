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
    private Integer couponDiscountRate;
    private String receivedDate;
    private String couponExpirationDate;
    private Boolean status;
    private Integer userIdx;
}
