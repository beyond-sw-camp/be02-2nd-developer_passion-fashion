package com.example.msaProductList.application.port.in;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize
public class CreateProductCommand {
    private String productName;
    private String brandName;
    private Integer brandIdx;
    private Integer quantity;
    private Integer price;
    private String image;
}
