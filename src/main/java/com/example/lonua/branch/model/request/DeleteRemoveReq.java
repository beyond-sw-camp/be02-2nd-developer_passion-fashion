package com.example.lonua.branch.model.request;

import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "asdqweasd")
public class DeleteRemoveReq {

    @Min(value = 1)
    @ApiModelProperty(value = "삭제할 가게의 idx")
    private Integer branchIdx;
}
