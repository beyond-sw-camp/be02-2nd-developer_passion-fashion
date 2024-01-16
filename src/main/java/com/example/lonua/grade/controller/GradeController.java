package com.example.lonua.grade.controller;


import com.example.lonua.grade.model.request.GetReadReq;
import com.example.lonua.grade.model.request.PatchUpdateReq;
import com.example.lonua.grade.model.request.PostCreateReq;
import com.example.lonua.grade.service.GradeService;
import io.swagger.annotations.ApiOperation;
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
public class GradeController {
    private final GradeService gradeService;
    @ApiOperation(value = "등급 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registerGrade(@RequestBody @Valid PostCreateReq postCreateReq) {
        return ResponseEntity.ok().body(gradeService.create(postCreateReq));
    }
    @ApiOperation(value = "등급 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listGrade() {
        return ResponseEntity.ok().body(gradeService.list());
    }

    @ApiOperation(value = "등급 하나 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readGrade(@RequestBody @Valid GetReadReq request) {
        return ResponseEntity.ok().body(gradeService.read(request));
    }
    @ApiOperation(value = "등급 정보 수정하기")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateGrade(@RequestBody @Valid PatchUpdateReq request) {
        return ResponseEntity.ok().body(gradeService.update(request));
    }
//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    ResponseEntity deleteBranch(DeleteRemoveReq request) {
//        return ResponseEntity.ok().body(branchService.delete(request));
//    }
}
