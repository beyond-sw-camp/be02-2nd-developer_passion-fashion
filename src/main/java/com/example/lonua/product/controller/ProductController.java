package com.example.lonua.product.controller;

import com.example.lonua.common.BaseRes;
import com.example.lonua.product.model.request.PatchUpdateProductReq;
import com.example.lonua.product.model.request.PostRegisterProductReq;
import com.example.lonua.product.service.ProductService;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@Api(tags = "상품 기능",value = "ProductController")
public class ProductController {

    private final ProductService productService;
    @ApiOperation(value = "물품 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(
            @RequestPart(value = "product") @Valid PostRegisterProductReq postRegisterProductReq,
            @RequestPart(value = "productImage") MultipartFile[] productFiles,
            @RequestPart(value = "productIntrodImage") MultipartFile[] productIntrodFiles
    ) {
        BaseRes baseRes = productService.register(postRegisterProductReq, productFiles, productIntrodFiles);

        return ResponseEntity.ok().body(baseRes);
    }


    @ApiOperation(value = "물품 페이징 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size) {

        BaseRes baseRes = productService.list(page, size);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "물품 상세 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity read(@PathVariable @Min(value = 1) Integer idx) {
        BaseRes baseRes = productService.read(idx);
        return ResponseEntity.ok().body(baseRes);
    }

    // 상품 정보 수정
    @ApiOperation(value = "물품 상세 정보 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody @Valid PatchUpdateProductReq patchUpdateProductReq) {

        BaseRes baseRes = productService.update(patchUpdateProductReq);
        return ResponseEntity.ok().body(baseRes);
    }
    // 상품 삭제
    @ApiOperation(value = "물품 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable @Min(value = 1) Integer idx) {

        BaseRes baseRes = productService.delete(idx);
        return ResponseEntity.ok().body(baseRes);
    }

    //----------------------검색 기능-------------------------
    // 1. 카테고리 별 상품 리스트 검색(최신 등록 순)
    @ApiOperation(value = "물품 카테고리 별 검색 기능")
    @RequestMapping(method = RequestMethod.GET, value = "/categorylist/{categoryIdx}/{page}/{size}")
    public ResponseEntity list(@PathVariable @Min(value = 1) Integer categoryIdx, @PathVariable @Min(value = 1) Integer page, @PathVariable @Max(40) Integer size) {
        BaseRes baseRes = productService.categoryProductlist(categoryIdx, page, size);
        return ResponseEntity.ok().body(baseRes);
    }


    // 2. 같은 상/하체 체형을 가진 사람이 많이 주문한 상품 리스트 검색(상체 - 하체 순 정렬)
    @RequestMapping(method = RequestMethod.GET, value = "/sametype/{page}/{size}")
    public ResponseEntity sameTypeProductList(@PathVariable Integer page, @PathVariable Integer size) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        BaseRes baseRes = productService.sameTypeProductList(user, page, size);
        return ResponseEntity.ok().body(baseRes);
    }
}
