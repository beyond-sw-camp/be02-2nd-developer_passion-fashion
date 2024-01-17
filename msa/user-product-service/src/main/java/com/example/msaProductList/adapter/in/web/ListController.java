package com.example.msaProductList.adapter.in.web;

import com.common.WebAdapter;
import com.example.msaProductList.application.port.in.ListProductInPort;
import com.example.msaProductList.domain.Product;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/msa/product/")
public class ListController {
    private final ListProductInPort listProductInPort;
    @ApiOperation(value = "물품 페이징 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size) {

        List<Product> result= listProductInPort.list(page, size);

        return ResponseEntity.ok().body(BaseRes.builder()
                        .code(200)
                        .isSuccess(true)
                        .message("요청 처리 완료.")
                        .result(result)
                .build());
    }
}
