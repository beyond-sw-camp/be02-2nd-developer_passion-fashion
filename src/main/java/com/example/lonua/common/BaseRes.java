package com.example.lonua.common;

import io.swagger.annotations.ApiModel;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.media.Schema;
=======
import io.swagger.annotations.ApiModelProperty;
>>>>>>> develop
import lombok.*;
import springfox.documentation.schema.Example;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
@ApiModel(description = "모든 반환값을 담는 DTO",value = "기본 응답")
@Schema(description = "모든 반환값을 담는 DTO")
=======
@ApiModel(description = "Base response")
>>>>>>> develop
public class BaseRes {

    @ApiModelProperty(value = "Response code", example = "200")
    private Integer code;

    @ApiModelProperty(value = "Is success flag", example = "true")
    private Boolean isSuccess;

    @ApiModelProperty(value = "Response message", example = "Success")
    private String message;

    @ApiModelProperty(value = "Result data", notes = "API 마다 반환되는 결과가 달라짐")
    private Object result;
}
