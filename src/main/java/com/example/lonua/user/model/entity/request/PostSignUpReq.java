package com.example.lonua.user.model.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSignUpReq {


    @NotNull
    @Length(max=45) //????
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$") //TODO 정규표현 식 입력해야함.
    @ApiModelProperty(value = "사용자 이메일", example = "test@example.com", required = true)
    private String userEmail;
    @NotNull
    @Length(min=8,max=100)
    @ApiModelProperty(value = "사용자 PW(최소 길이:8)", example = "qwer1234@", required = true)
    private String userPassword;


    @NotNull
    @Length(max=45)
    @ApiModelProperty(value = "사용자 실명", example = "홍길동", required = true)
    private String userName;

    @NotNull
    @Length(max=45) //???? 8자리로 입력 받을까>? yyyy-mm-dd
    @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$", message = "올바른 날짜 형식을 사용하세요 (yyyymmdd).")
    @ApiModelProperty(value = "사용자 생일", example = "19990101", required = true)
    private String userBirth;

    @NotNull
    @Length(max=1) //????
    @Pattern(regexp = "^[MW]$", message = "'M' 또는 'W'로 입력하세요.") //TODO 정규표현 식 입력해야함. (M or W)
    @ApiModelProperty(value = "사용자 성별", example = "M", required = true)
    private String userGender;

    @NotNull
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$") //TODO 정규표현 식 입력해야함.
    @ApiModelProperty(value = "사용자 핸드폰 번호", example = "01012345678", required = true)
    private String userPhoneNumber;


    @NotNull
    @Length(max=45) //????
    @ApiModelProperty(value = "사용자 주소", example = "서울시 덕양구", required = true)
    private String userAddr;

    @NotNull
    @Length(max=10) //????
    @ApiModelProperty(value = "사용자 선호 스타일", example = "빈티지", required = true)
    private String preferStyle;

    @NotNull
    @Range(min = 1,max = 3)
    @ApiModelProperty(value = "사용자 상의 사이즈(1~3)", example = "1", required = true)
    private Integer upperType;

    @NotNull
    @Range(min = 1,max = 3)
    @ApiModelProperty(value = "사용자 하의 사이즈1~3)", example = "1", required = true)
    private Integer lowerType;
}
