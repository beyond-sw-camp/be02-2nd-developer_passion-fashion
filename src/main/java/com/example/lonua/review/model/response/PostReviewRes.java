package com.example.lonua.review.model.response;

import com.example.lonua.product.model.entity.Product;
import com.example.lonua.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReviewRes {

    private String reviewContent;
    private String reviewPhoto;
    private Integer evaluation;
    private String createdAt;
    private String updatedAt;
    private Boolean status;

    private String productName;
    private String productImage;
}
