package com.example.lonua.review.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchUpdateReviewReq {

    private Integer reviewIdx;

    private String reviewContent;
    private String reviewPhoto;
    private Integer evaluation;

}
