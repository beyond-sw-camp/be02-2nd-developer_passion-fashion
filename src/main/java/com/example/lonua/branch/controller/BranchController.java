package com.example.lonua.branch.controller;

import com.example.lonua.branch.model.request.*;
import com.example.lonua.branch.service.BranchService;
<<<<<<< HEAD

import com.example.lonua.common.BaseRes;
import com.example.lonua.exception.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

=======
import com.example.lonua.common.BaseRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
>>>>>>> develop
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import javax.swing.text.html.parser.Entity;
=======
>>>>>>> develop
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/branch")
@Api(value="지점 컨트롤러 v1", tags="지점 API")
public class BranchController {
    private final BranchService branchService;

<<<<<<< HEAD
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 등록 성공", content = @Content(schema = @Schema(implementation = BaseRes.class)))}
            )
    @ApiOperation(value = "가게 등록하기")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerBranch(@RequestBody @Valid PostRegisterReq request) {

        return ResponseEntity.ok().body(branchService.create(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 목록 조회 성공", content = @Content(schema = @Schema(implementation = BaseRes.class))),
    })
    @ApiOperation(value = "가게 목록 조회하기")
=======

    @ApiOperation(value = "지점 등록", response = BaseRes.class, notes = "판매자가 지점을 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "지점 등록 성공", content = @Content(mediaType = "application/json",schema = @Schema(implementation = BaseRes.class)))}
    )
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerBranch(@RequestBody @Valid PostBranchRegisterReq request) {
        return ResponseEntity.ok().body(branchService.create(request));
    }
    @ApiOperation(value = "지점 모두 조회", response = BaseRes.class, notes = "판매자가 지점을 모두 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "지점 모두 조회 성공", content = @Content(mediaType = "application/json",schema = @Schema(implementation = BaseRes.class)))}
    )
>>>>>>> develop
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listBranch(@RequestBody @Valid GetBranchListReq request) {
        return ResponseEntity.ok().body(branchService.list(request));
    }

<<<<<<< HEAD
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 조회 성공", content = @Content(schema = @Schema(implementation = BaseRes.class))),
    })
    @ApiOperation(value = "가게 하나 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readBranch(@RequestBody @Valid GetReadReq request) {
        return ResponseEntity.ok().body(branchService.read(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 정보 수정 성공", content = @Content(schema = @Schema(implementation = BaseRes.class))),
    })
    @ApiOperation(value = "가게 상세 정보 수정하기")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateBranch(@RequestBody @Valid PatchUpdateReq request) {
        return ResponseEntity.ok().body(branchService.update(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 삭제 성공", content = @Content(schema = @Schema(implementation = BaseRes.class))),
    })
    @ApiOperation(value = "가게 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteBranch(@RequestBody @Valid DeleteRemoveReq request) {
=======
    @ApiOperation(value = "지점 단일 조회", response = BaseRes.class, notes = "판매자가 지점을 단일 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "지점 단일 조회 성공", content = @Content(mediaType = "application/json",schema = @Schema(implementation = BaseRes.class)))}
    )
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readBranch(@Valid GetBranchReadReq request) {
        return ResponseEntity.ok().body(branchService.read(request));
    }

    @ApiOperation(value = "지점 정보 수정", response = BaseRes.class, notes = "판매자가 지점정보를 수정한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "지점 정보 수정 성공", content = @Content(mediaType = "application/json",schema = @Schema(implementation = BaseRes.class)))}
    )
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateBranch(@RequestBody @Valid PatchBranchUpdateReq request) {
        return ResponseEntity.ok().body(branchService.update(request));
    }

    @ApiOperation(value = "지점 삭제", response = BaseRes.class, notes = "판매자가 지점을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "지점 삭제 성공", content = @Content(mediaType = "application/json",schema = @Schema(implementation = BaseRes.class)))}
    )
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteBranch(@RequestBody @Valid DeleteBranchRemoveReq request) {
>>>>>>> develop
        return ResponseEntity.ok().body(branchService.delete(request));
    }

}
