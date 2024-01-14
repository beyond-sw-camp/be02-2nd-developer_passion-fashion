package com.example.lonua.user.model.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUserLoginReq {

    @NotNull
    @Length(max=45)
    @ApiModelProperty(value = "사용자 ID", example = "test1", required = true)
    private String email;

    @NotNull
    @Length(min=8,max=200)
    @ApiModelProperty(value = "사용자 PW(최소 길이:8)", example = "qwer1234@", required = true)
    private String password;

}
