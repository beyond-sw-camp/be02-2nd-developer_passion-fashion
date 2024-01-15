package com.example.lonua.branch.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetReadReq {
    @Length(max = 50)
    @ApiModelProperty(value = "조회할 가게의 이름")
    private String branchName;
}
