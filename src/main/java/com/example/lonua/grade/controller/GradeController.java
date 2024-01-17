package com.example.lonua.grade.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.grade.model.request.PatchGradeUpdateReq;
import com.example.lonua.grade.model.request.PostGradeCreateReq;
import com.example.lonua.grade.service.GradeService;
<<<<<<< HEAD
import io.swagger.annotations.ApiOperation;
=======
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
>>>>>>> develop
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
@Api(value="등급 컨트롤러 v1", tags="등급 API")
public class GradeController {
    private final GradeService gradeService;
<<<<<<< HEAD

    @ApiOperation(value = "등급 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registerGrade(@RequestBody @Valid PostCreateReq postCreateReq) {
        return ResponseEntity.ok().body(gradeService.create(postCreateReq));
    }

    @ApiOperation(value = "등급 목록 가져오기")
=======
    @ApiOperation(value = "등급 등록", response = BaseRes.class, notes = "관리자가 등급을 추가한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registerGrade(@RequestBody @Valid PostGradeCreateReq postGradeCreateReq) {
        return ResponseEntity.ok().body(gradeService.create(postGradeCreateReq));
    }
    @ApiOperation(value = "등급 조회", response = BaseRes.class, notes = "관리자가 등급을 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
>>>>>>> develop
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listGrade() {
        return ResponseEntity.ok().body(gradeService.list());
    }

<<<<<<< HEAD
    @ApiOperation(value = "등급 하나 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readGrade(@RequestBody @Valid GetReadReq request) {
        return ResponseEntity.ok().body(gradeService.read(request));
    }

    @ApiOperation(value = "등급 정보 수정하기")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateGrade(@RequestBody @Valid PatchUpdateReq request) {
=======
//    @ApiOperation(value = "등급 하나 가져오기")
//    @RequestMapping(method = RequestMethod.GET, value = "/read")
//    ResponseEntity readGrade(@RequestBody @Valid GetReadReq request) {
//        return ResponseEntity.ok().body(gradeService.read(request));
//    }
@ApiOperation(value = "등급 수정", response = BaseRes.class, notes = "관리자가 등급정보를 수정한다..")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateGrade(@RequestBody @Valid PatchGradeUpdateReq request) {
>>>>>>> develop
        return ResponseEntity.ok().body(gradeService.update(request));
    }
//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    ResponseEntity deleteBranch(DeleteRemoveReq request) {
//        return ResponseEntity.ok().body(branchService.delete(request));
//    }
}
