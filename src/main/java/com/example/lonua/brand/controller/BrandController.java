package com.example.lonua.brand.controller;

import com.example.lonua.brand.model.request.PatchUpdateBrandReq;
import com.example.lonua.brand.model.request.PostRegisterBrandReq;
import com.example.lonua.brand.service.BrandService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.example.lonua.common.BaseRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
=======
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
>>>>>>> develop

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
@Api(value="브랜드(판매자) 컨트롤러 v1", tags="브랜드(판매자) API")
public class BrandController {

    private final BrandService brandService;

<<<<<<< HEAD
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ApiOperation(value = "판매자 등록")
=======
    @ApiOperation(value = "브랜드 등록", response = BaseRes.class, notes = "관리자가 브랜드를 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
>>>>>>> develop
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(
            @RequestPart(value = "brand") @Valid PostRegisterBrandReq postRegisterBrandReq,
            @RequestPart(value = "brandImage") @NotNull MultipartFile brandFile) {
        BaseRes baseRes = brandService.register(postRegisterBrandReq, brandFile);

        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD
    @ApiOperation(value = "판매자 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(
            @ApiParam(name = "페이지 번호") @PathVariable Integer page,
            @ApiParam(name = "페이지 수량") @PathVariable Integer size) {
=======

    @ApiOperation(value = "브랜드 목록 조회", response = BaseRes.class, notes = "관리자가 브랜드 목록을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable @NotNull @Positive Integer page, @PathVariable @NotNull @Positive Integer size) {
>>>>>>> develop
        BaseRes baseRes = brandService.list(page, size);

        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD
    @ApiOperation(value = "판매자 상세 정보 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity read(@ApiParam(name = "브랜드 IDX") @PathVariable Integer idx) {
=======

    @ApiOperation(value = "특정 브랜드 정보 조회", response = BaseRes.class, notes = "관리자가 특정 브랜드의 정보를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity read(@PathVariable @NotNull @Positive Integer idx) {
>>>>>>> develop
        BaseRes baseRes = brandService.read(idx);
        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD
    @ApiOperation(value = "판매자 상세 정보 수정")
=======

    @ApiOperation(value = "브랜드 정보 수정", response = BaseRes.class, notes = "관리자가 브랜드 정보를 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
>>>>>>> develop
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(
            @RequestPart(value = "brand") @Valid PatchUpdateBrandReq patchUpdateBrandReq,
            @RequestPart(value = "brandImage") MultipartFile brandFile) {
        BaseRes baseRes = brandService.update(patchUpdateBrandReq, brandFile);
        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD
    @ApiOperation(value = "판매자 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@ApiParam(name = "브랜드 IDX") @PathVariable Integer idx) {
=======

    @ApiOperation(value = "브랜드 삭제", response = BaseRes.class, notes = "관리자가 브랜드를 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable @NotNull @Positive Integer idx) {

>>>>>>> develop
        BaseRes baseRes = brandService.delete(idx);
        return ResponseEntity.ok().body(baseRes);
    }
}
