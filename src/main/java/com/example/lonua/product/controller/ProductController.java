package com.example.lonua.product.controller;

import com.example.lonua.config.BaseRes;
import com.example.lonua.product.model.request.PatchUpdateProductReq;
import com.example.lonua.product.model.request.PostRegisterProductReq;
import com.example.lonua.product.model.response.PostRegisterProductRes;
import com.example.lonua.product.service.ProductService;
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
=======
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
>>>>>>> feature/swagger
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@Api(tags = "Product API")
public class ProductController {

    private final ProductService productService;

<<<<<<< HEAD
    // 상품 등록
=======
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @ApiOperation(value = "물품 등록")
>>>>>>> feature/swagger
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(
            @RequestPart(value = "product") PostRegisterProductReq postRegisterProductReq,
            @RequestPart(value = "productImage") MultipartFile[] productFiles,
            @RequestPart(value = "productIntrodImage") MultipartFile[] productIntrodFiles
    ) {
        BaseRes baseRes = productService.register(postRegisterProductReq, productFiles, productIntrodFiles);

        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD

    // 페이징 별 상품 조회
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(Integer page, Integer size) {
=======
    @ApiOperation(value = "물품 전체 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
>>>>>>> feature/swagger

        BaseRes baseRes = productService.list(page, size);
        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD

=======
    @ApiOperation(value = "물품 상세 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(@ApiParam(value = "상품 ID") Integer productIdx) {
>>>>>>> feature/swagger

    // 상품 세부 조회
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity read(@PathVariable Integer idx) {

        BaseRes baseRes = productService.read(idx);
        return ResponseEntity.ok().body(baseRes);
    }

    // 상품 정보 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody PatchUpdateProductReq patchUpdateProductReq) {

        BaseRes baseRes = productService.update(patchUpdateProductReq);
        return ResponseEntity.ok().body(baseRes);
    }

    // 상품 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable Integer idx) {

        BaseRes baseRes = productService.delete(idx);
        return ResponseEntity.ok().body(baseRes);
    }

    //----------------------검색 기능-------------------------
    // 1. 카테고리 별 상품 리스트 검색(최신 등록 순)
    @RequestMapping(method = RequestMethod.GET, value = "/categorylist/{categoryIdx}/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer categoryIdx, @PathVariable Integer page, @PathVariable Integer size) {

        BaseRes baseRes = productService.categoryProductlist(categoryIdx, page, size);
        return ResponseEntity.ok().body(baseRes);
    }

}
