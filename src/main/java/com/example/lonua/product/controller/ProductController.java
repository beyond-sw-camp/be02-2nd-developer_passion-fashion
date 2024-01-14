package com.example.lonua.product.controller;

import com.example.lonua.product.model.request.PostRegisterProductReq;
import com.example.lonua.product.model.response.PostRegisterProductRes;
import com.example.lonua.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@Api(tags = "Product API")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @ApiOperation(value = "물품 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(PostRegisterProductReq postRegisterProductReq) {
        PostRegisterProductRes postRegisterProductRes = productService.register(postRegisterProductReq);

        return ResponseEntity.ok().body(postRegisterProductRes);
    }
    @ApiOperation(value = "물품 전체 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {

        return ResponseEntity.ok().body(productService.list());
    }
    @ApiOperation(value = "물품 상세 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(@ApiParam(value = "상품 ID") Integer productIdx) {

        return ResponseEntity.ok().body(productService.read(productIdx));
    }
}
