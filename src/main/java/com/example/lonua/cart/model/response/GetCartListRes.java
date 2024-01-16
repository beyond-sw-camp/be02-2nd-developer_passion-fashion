package com.example.lonua.cart.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
<<<<<<< HEAD:src/main/java/com/example/lonua/cart/model/request/DeleteRemoveReq.java
public class DeleteRemoveReq {
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "카트 idx", example = "1", required = true)
=======
public class GetCartListRes {
>>>>>>> develop:src/main/java/com/example/lonua/cart/model/response/GetCartListRes.java
    private Integer cartIdx;
    private String productName;
    private Integer price;
}
