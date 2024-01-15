package com.example.lonua.question.model.request;


import com.example.lonua.product.model.entity.Product;
import com.example.lonua.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRegisterQuestionReq {

    private Integer productIdx;

    private String questionType;  // 사이즈, 배송, 재입고, 상품 상세문의
    private String questionTitle;
    private String questionContent;
    private Boolean isSecret;

}
