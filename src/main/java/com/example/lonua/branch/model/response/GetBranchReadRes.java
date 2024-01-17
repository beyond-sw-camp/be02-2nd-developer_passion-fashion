package com.example.lonua.branch.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetBranchReadRes {
    private Integer branchIdx;
    @Length(max = 50)
    @ApiModelProperty(value = "수정할 가게의 이름값", name = "가게 이름")
    private String branchName;

    @Length(max = 50)
    @ApiModelProperty(value = "수정할 가게의 주소값", name = "가게 주소")
    private String branchAddress;
    private Integer brandIdx;
}
