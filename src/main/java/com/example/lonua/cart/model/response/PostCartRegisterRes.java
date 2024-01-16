package com.example.lonua.cart.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
<<<<<<< HEAD:src/main/java/com/example/lonua/cart/model/request/PostRegisterReq.java
public class PostRegisterReq {
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "장바구니에 담을 상품 idx", example = "1", required = true)
=======
public class PostCartRegisterRes {

    private Integer cartIdx;
>>>>>>> develop:src/main/java/com/example/lonua/cart/model/response/PostCartRegisterRes.java
    private Integer productIdx;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "장바구니를 이용하는 유저 idx", example = "1", required = true)
    private Integer userIdx;
    private String createdAt;
    private String updatedAt;
    private Boolean status;
}
