package com.example.msaProductCreate.adapter.in.web;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "모든 반환값을 담는 DTO",value = "기본 응답")
@Schema(description = "모든 반환값을 담는 DTO")
public class BaseRes {
    private Integer code;
    private Boolean isSuccess;
    private String message;
    private Object result;
}
