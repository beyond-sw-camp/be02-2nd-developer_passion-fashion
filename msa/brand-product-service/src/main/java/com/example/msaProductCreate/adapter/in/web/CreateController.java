package com.example.msaProductCreate.adapter.in.web;

import com.common.WebAdapter;
import com.example.msaProductCreate.application.port.in.CreateProductCommand;
import com.example.msaProductCreate.application.port.in.CreateProductInport;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/msa/product")
@CrossOrigin("*") // CORS policy 벡엔드 url과 요청 url이 다를 때 생기는 에러
public class CreateController {
    private final CreateProductInport createProductInport;
    @RequestMapping(method = RequestMethod.PUT, value = "/create")
    public ResponseEntity create(@RequestBody CreateProductCommand createProductCommand) {

        return ResponseEntity.ok().body(BaseRes.builder()
                        .code(200)
                        .isSuccess(true)
                        .message("요청 처리 완료.")
                        .result(createProductInport.create(createProductCommand))
                .build());
    }
}
