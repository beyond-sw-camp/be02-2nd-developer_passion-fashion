package com.example.lonua.branch.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "가게 데이터를 삭제 요청받을 때 쓰는 DTO",value = "A Branch DeleteRemoveReqDTO")
public class DeleteRemoveReq {

    @Min(value = 1)
    @ApiModelProperty(value = "삭제할 가게의 idx",name = "가게의 idx")
    private Integer branchIdx;
}
