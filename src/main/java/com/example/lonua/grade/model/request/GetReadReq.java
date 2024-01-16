package com.example.lonua.grade.model.request;

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
    @Length(max=20)
    @ApiModelProperty(value = "조회할 등급의 이름", example = "골드", required = true)
    private String gradeType;
}
