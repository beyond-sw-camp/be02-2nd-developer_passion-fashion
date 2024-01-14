package com.example.lonua.grade.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PatchUpdateReq {
    private Integer gradeIdx;
    private String gradeType;
    private Integer discountRate;
}
