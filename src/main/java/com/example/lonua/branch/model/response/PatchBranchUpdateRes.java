package com.example.lonua.branch.model.response;

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
public class PatchBranchUpdateRes {
    private Integer branchIdx;
    private String branchName;
    private String branchAddress;
    private Integer brandIdx;
}
