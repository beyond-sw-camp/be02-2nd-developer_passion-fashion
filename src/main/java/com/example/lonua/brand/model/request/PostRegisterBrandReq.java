package com.example.lonua.brand.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRegisterBrandReq {

    private String brandName;
    private String brandIntroduction;
    private String brandStyle;
    private String businessAddress;
    private String phoneNumber;
    private String businessRegistration;
    private String bankAccountNumber;
    private String returnAddress;
    private Integer returnCost;
    private String returnCourier;

}
