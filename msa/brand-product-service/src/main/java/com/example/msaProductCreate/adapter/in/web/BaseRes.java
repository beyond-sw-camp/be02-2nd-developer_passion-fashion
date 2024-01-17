package com.example.msaProductCreate.adapter.in.web;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseRes {
    private Integer code;
    private Boolean isSuccess;
    private String message;
    private Object result;
}
