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
<<<<<<< HEAD:src/main/java/com/example/lonua/grade/model/request/PatchUpdateReq.java
public class PatchUpdateReq {
    @Min(value = 1)
    @ApiModelProperty(value = "수정할 등급의 idx", example = "1", required = true)
=======
public class GetGradeListRes {
>>>>>>> develop:src/main/java/com/example/lonua/grade/model/response/GetGradeListRes.java
    private Integer gradeIdx;

    @Length(max=20)
    @ApiModelProperty(value = "수정값 : 등급의 이름", example = "골드", required = true)
    private String gradeType;


    @Range(min = 1, max = 10)
    @ApiModelProperty(value = "수정값 : 등급의 할인율", example = "5", required = true)
    private Integer discountRate;
}
