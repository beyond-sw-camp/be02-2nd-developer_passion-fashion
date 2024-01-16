package com.example.lonua.grade.model.response;

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
<<<<<<< HEAD:src/main/java/com/example/lonua/grade/model/request/GetReadReq.java
public class GetReadReq {
    @Length(max=20)
    @ApiModelProperty(value = "조회할 등급의 이름", example = "골드", required = true)
=======
public class GetGradeReadRes {
    private Integer gradeIdx;
>>>>>>> develop:src/main/java/com/example/lonua/grade/model/response/GetGradeReadRes.java
    private String gradeType;
    private Integer discountRate;
}
