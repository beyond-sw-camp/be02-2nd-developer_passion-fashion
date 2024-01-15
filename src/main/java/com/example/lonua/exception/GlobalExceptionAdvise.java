package com.example.lonua.exception;

import com.amazonaws.SdkClientException;
import com.example.lonua.exception.errorCode.ErrorCode;
import com.example.lonua.exception.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static com.example.lonua.exception.errorCode.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.example.lonua.exception.errorCode.ErrorCode.INVALID_INPUT_VALUE;

@RestControllerAdvice
public class GlobalExceptionAdvise extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionAdvise.class);


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity NumberFormatEx(NumberFormatException e) {

        log.error("숫자가 아닌 값이 입력되었습니다.");
        return makeResponseEntity(INVALID_INPUT_VALUE);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity handleUserException(UserException e) {

        log.error("입력한 ID가 중복되었습니다.");
        return makeResponseEntity(e.getErrorCode());
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity sqlException(SQLException e) {

        log.error("sqlException");
        return makeResponseEntity(INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SdkClientException.class)
    public ResponseEntity sdkEC2Exception(SdkClientException e) {

        log.error("AwsException");
        return makeResponseEntity(INTERNAL_SERVER_ERROR);
    }




    public ResponseEntity makeResponseEntity(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getStatus()).body(ErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build());
    }
}
