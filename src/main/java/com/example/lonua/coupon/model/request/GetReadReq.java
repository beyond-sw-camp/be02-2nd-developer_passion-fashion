package com.example.lonua.coupon.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetReadReq {
    @Min(value = 1)
    @ApiModelProperty(value = "조회할 쿠폰 Idx", example = "1", required = true)
    private Integer couponIdx;
}
