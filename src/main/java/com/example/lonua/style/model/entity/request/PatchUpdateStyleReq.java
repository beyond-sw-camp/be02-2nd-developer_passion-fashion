package com.example.lonua.style.model.entity.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatchUpdateStyleReq {
    private Integer styleIdx;
    private String StyleType;
}
