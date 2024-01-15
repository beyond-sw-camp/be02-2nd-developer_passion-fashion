package com.example.lonua.user.model.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUserLoginReq {

    @NotNull
    @Length(max=45)
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",message = "이메일을 입력하세요.") //TODO 정규표현 식 입력해야함.
    @ApiModelProperty(value = "사용자 ID", example = "test1", required = true)
    private String email;

    @NotNull
    @Length(min=8,max=200)
    @ApiModelProperty(value = "사용자 PW(최소 길이:8)", example = "qwer1234@", required = true)
    private String password;

}
