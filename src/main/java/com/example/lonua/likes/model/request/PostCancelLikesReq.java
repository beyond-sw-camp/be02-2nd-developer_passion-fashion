package com.example.lonua.likes.model.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCancelLikesReq {
<<<<<<< HEAD
    @Min(value = 1)
    @ApiModelProperty(value = "삭제할 likes의 idx", example = "1", required = true)
    private Integer likesIdx;

    @Min(value = 1)
    @ApiModelProperty(value = "삭제할 likes의 제품의 idx", example = "1", required = true)
    private Integer productIdx; // 왜 있는거지?
=======

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "좋아요 IDX( 1이상의 숫자 )", example = "1", required = true)
    private Integer likesIdx;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "상품 IDX( 1이상의 숫자 )", example = "1", required = true)
    private Integer productIdx;
>>>>>>> develop
}
