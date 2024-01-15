package com.example.lonua.branch.model.request;

import io.swagger.annotations.ApiModelProperty;
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
public class PatchUpdateReq {
    @Min(value = 1)
    @ApiModelProperty(value = "수정할 가게를 찾기 위한 가게의 idx")
    private Integer branchIdx;

    @Length(max = 50)
    @ApiModelProperty(value = "수정할 가게의 이름값")
    private String branchName;

    @Length(max = 50)
    @ApiModelProperty(value = "수정할 가게의 주소값")
    private String branchAddress;
}
