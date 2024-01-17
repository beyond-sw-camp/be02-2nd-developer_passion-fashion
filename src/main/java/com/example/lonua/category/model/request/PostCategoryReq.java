package com.example.lonua.category.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCategoryReq {
    @NotNull
    @Length(max = 30)
    @ApiModelProperty(value = "등록할 카테고리 이름", example = "후드티", required = true)
    private String categoryName;

}
