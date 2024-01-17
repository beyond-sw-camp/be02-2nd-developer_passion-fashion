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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GetBranchListRes {
    private Integer branchIdx;
    private String branchName;
    @Length(max = 50)
    @ApiModelProperty(value = "추가할 가게의 주소값")
    private String branchAddress;
    private Integer brandIdx;

}
