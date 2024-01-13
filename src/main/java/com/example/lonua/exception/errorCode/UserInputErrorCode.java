package com.example.lonua.exception.errorCode;

import org.springframework.http.HttpStatus;

public enum UserInputErrorCode {
    //특수문자
    //입력 길이
    //이메일 형식
    //비밀번호 복잡도

    // 데이터 베이스에 들어가는 모든 값들에는 들어가면 안되는 특수문자들이 있다.
    INVALID_INPUT(HttpStatus.UNAUTHORIZED, "USER-001", "금지된 특수 문자."),
    // 이메일
    INVALID_EMAIL_INPUT(HttpStatus.BAD_REQUEST, "USER-EMAIL-001", "이메일 형식이 아닌 입력입니다.(유효성 검증 실패"),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "USER-EMAIL-002", "이미 존재하는 사용자 이메일입니다."),
    SEND_EMAIL_FAIL(HttpStatus.BAD_REQUEST, "USER-EMAIL-003", "인증을 위한 메일 전송에 실패했습니다. 이메일을 확인해주세요."),


    // 패스워드
    INVALID_PASSWOR_PERMISIION(HttpStatus.BAD_REQUEST, "USER-PASSWORD-001", "8자 이상, 3가지 조합으로 입력해주세요."),
    INVALID_PASSWORD_PERMISIION(HttpStatus.BAD_REQUEST, "USER-PASSWORD-001", "8자 이상, 3가지 조합으로 입력해주세요."),
    // 닉네임
    INVALID_NICKNAME_PERMISIION(HttpStatus.BAD_REQUEST, "USER-NICKNAME-001", "특수문자 금지."),


    // Product
    DUPLICATED_PRODUCT(HttpStatus.CONFLICT, "PRODUCT-001", "이미 존재하는 상품명 입니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    UserInputErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
