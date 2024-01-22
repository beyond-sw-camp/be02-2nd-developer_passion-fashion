package com.example.lonua.grade.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class GetGradeListRes {
    private Integer gradeIdx;
    private String gradeType;
    private Integer discountRate;
}
