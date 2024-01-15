package com.example.lonua.brand.controller;

import com.example.lonua.brand.model.request.PatchUpdateBrandReq;
import com.example.lonua.brand.model.request.PostRegisterBrandReq;
import com.example.lonua.brand.service.BrandService;

import com.example.lonua.config.BaseRes;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ApiOperation(value = "판매자 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(
            @RequestPart(value = "brand") PostRegisterBrandReq postRegisterBrandReq,
            @RequestPart(value = "brandImage") MultipartFile brandFile) {
        BaseRes baseRes = brandService.register(postRegisterBrandReq, brandFile);

        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "판매자 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(
            @ApiParam(name = "페이지 번호") @PathVariable Integer page,
            @ApiParam(name = "페이지 수량") @PathVariable Integer size) {
        BaseRes baseRes = brandService.list(page, size);

        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "판매자 상세 정보 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity read(@ApiParam(name = "브랜드 IDX") @PathVariable Integer idx) {
        BaseRes baseRes = brandService.read(idx);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "판매자 상세 정보 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(
            @RequestPart(value = "brand")PatchUpdateBrandReq patchUpdateBrandReq,
            @RequestPart(value = "brandImage") MultipartFile brandFile) {
        BaseRes baseRes = brandService.update(patchUpdateBrandReq, brandFile);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "판매자 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@ApiParam(name = "브랜드 IDX") @PathVariable Integer idx) {
        BaseRes baseRes = brandService.delete(idx);
        return ResponseEntity.ok().body(baseRes);
    }
}
