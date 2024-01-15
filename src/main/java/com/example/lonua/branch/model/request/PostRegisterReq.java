package com.example.lonua.branch.model.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "가게 등록 요청 시 쓰는 DTO" ,value = "Branch PostRegisterRequest DTO")
public class PostRegisterReq {
    @Min(value = 1)
    @ApiModelProperty(value = "추가할 가게의 idx")
    private Integer branchIdx; //? 등록하는데 이게 왜 필요하지?
    @Length(max = 50)
    @ApiModelProperty(value = "추가할 가게의 이름")
    private String branchName;
    @Length(max = 50)
    @ApiModelProperty(value = "추가할 가게의 주소값")
    private String branchAddress;
}
