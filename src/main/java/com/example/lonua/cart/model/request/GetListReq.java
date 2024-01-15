package com.example.lonua.cart.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetListReq {
    private Integer userIdx;
    private Integer page;
    private Integer size;

}
