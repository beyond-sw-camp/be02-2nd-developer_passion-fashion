package com.example.lonua.coupon.model.request;

import com.example.lonua.user.model.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRegisterReq {
    @Min(value = 1)
    @ApiModelProperty(value = "쿠폰을 받을 사람의 Idx", example = "1", required = true)
    private Integer userIdx;

//    @Pattern(regexp = "^.{1,20}$", message = "20글자 이하의 문자열을 입력하세요.")
    @ApiModelProperty(value = "발급할 쿠폰의 이름", example = "1", required = true)
    private String couponName;

    @Range(min = 5,max= 100)
    @ApiModelProperty(value = "발급할 쿠폰의 할인율", example = "50", required = true)
    private Integer couponDiscountRate;


    @ApiModelProperty(value = "발급할 쿠폰의 상태", example = "false", required = true)
    private Boolean status;  // 필요있나?
}
