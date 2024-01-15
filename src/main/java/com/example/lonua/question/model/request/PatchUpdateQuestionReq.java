package com.example.lonua.question.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchUpdateQuestionReq {
    private Integer questionIdx;
    private String questionType;
    private String questionTitle;
    private String questionContent;
    private Boolean isSecret;
}
