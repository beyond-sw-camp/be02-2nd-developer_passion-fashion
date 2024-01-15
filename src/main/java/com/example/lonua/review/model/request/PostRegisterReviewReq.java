package com.example.lonua.review.model.request;

import com.example.lonua.product.model.entity.Product;
import com.example.lonua.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRegisterReviewReq {

    private Integer productIdx;
    private Integer userIdx;

    private String reviewContent;
    private Integer evaluation;
    private String updatedAt;

}
