package com.example.lonua.review.model.request;

import com.example.lonua.product.model.entity.Product;
import com.example.lonua.user.model.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReviewReq {
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "리뷰 IDX", example = "1")
    private Integer reviewIdx;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "리뷰 대상 상품 IDX", example = "1")
    private Integer productIdx;

//    @NotNull
//    @Min(value = 1)
//    @ApiModelProperty(value = "리뷰 작성자 IDX", example = "1")
//    private Integer userIdx;

    @NotNull
    @Length(max = 500)
    @ApiModelProperty(value = "리뷰 내용", example = "제품이 친절하고 사장님이 맛있어요")
    private String reviewContent;

    //@NotNull
    //@Length(max = 500)
    @ApiModelProperty(value = "리뷰 첨부 사진")
    private String reviewPhoto;

    @NotNull
    @Range(min = 1,max = 5)
    @ApiModelProperty(value = "리뷰 평가 점수 내용", example = "1",notes="1~5 사이의 정수를 입력하세요.")
    private Integer evaluation;

    //private String createdAt;
    //private String updatedAt;
    //private Boolean status;
}
