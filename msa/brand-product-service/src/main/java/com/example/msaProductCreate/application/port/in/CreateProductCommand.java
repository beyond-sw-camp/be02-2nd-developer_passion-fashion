package com.example.msaProductCreate.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand {
    private Integer brandIdx;
    private String brandName;
    private String productName;
    private Integer quantity;
    private Integer price;
    private String image;
}
