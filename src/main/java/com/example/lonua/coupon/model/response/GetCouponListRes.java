package com.example.lonua.coupon.model.response;


<<<<<<< HEAD:src/main/java/com/example/lonua/coupon/model/request/PostRegisterReq.java
import com.example.lonua.user.model.entity.User;
import io.swagger.annotations.ApiModelProperty;
=======
>>>>>>> develop:src/main/java/com/example/lonua/coupon/model/response/GetCouponListRes.java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

<<<<<<< HEAD:src/main/java/com/example/lonua/coupon/model/request/PostRegisterReq.java
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

=======
>>>>>>> develop:src/main/java/com/example/lonua/coupon/model/response/GetCouponListRes.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/com/example/lonua/coupon/model/request/PostRegisterReq.java
public class PostRegisterReq {
    @Min(value = 1)
    @ApiModelProperty(value = "쿠폰을 받을 사람의 Idx", example = "1", required = true)
    private Integer userIdx;

    @Pattern(regexp = "^.{1,20}$", message = "20글자 이하의 문자열을 입력하세요.")
    @ApiModelProperty(value = "발급할 쿠폰의 이름", example = "1", required = true)
=======
public class GetCouponListRes {
    private Integer couponIdx;
>>>>>>> develop:src/main/java/com/example/lonua/coupon/model/response/GetCouponListRes.java
    private String couponName;

    @Range(min = 5,max= 100)
    @ApiModelProperty(value = "발급할 쿠폰의 할인율", example = "50", required = true)
    private Integer couponDiscountRate;
<<<<<<< HEAD:src/main/java/com/example/lonua/coupon/model/request/PostRegisterReq.java


    @ApiModelProperty(value = "발급할 쿠폰의 상태", example = "false", required = true)
    private Boolean status;  // 필요있나?
=======
    private String receivedDate;
    private String couponExpirationDate;
    private Boolean status;
    private Integer userIdx;
>>>>>>> develop:src/main/java/com/example/lonua/coupon/model/response/GetCouponListRes.java
}
