package com.example.lonua.style.model.entity.request;

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
public class PatchUpdateStyleReq {

    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    @ApiModelProperty(value = "스타일 IDX", example = "1", required = true)
    private Integer styleIdx;

    @NotNull
    @Length(max=7)
    @Pattern(regexp = "^(캐주얼|시크|댄디|스트릿|비지니스캐주얼|힙합|페미닌|오피스|스포츠)$")
    @ApiModelProperty(value = "스타일 유형", example = "댄디", required = true)
    private String StyleType;
}
