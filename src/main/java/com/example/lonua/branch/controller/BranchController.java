package com.example.lonua.branch.controller;

import com.example.lonua.branch.model.request.DeleteRemoveReq;
import com.example.lonua.branch.model.request.GetReadReq;
import com.example.lonua.branch.model.request.PatchUpdateReq;
import com.example.lonua.branch.model.request.PostRegisterReq;
import com.example.lonua.branch.service.BranchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/branch")
public class BranchController {
    private final BranchService branchService;

    @ApiOperation(value = "가게 등록하기")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerBranch(PostRegisterReq request) {
        return ResponseEntity.ok().body(branchService.create(request));
    }
    @ApiOperation(value = "가게 목록 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listBranch() {
        return ResponseEntity.ok().body(branchService.list());
    }

    @ApiOperation(value = "가게 하나 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readBranch(GetReadReq request) {
        return ResponseEntity.ok().body(branchService.read(request));
    }
    @ApiOperation(value = "가게 상세 정보 수정하기")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity updateBranch(PatchUpdateReq request) {
        return ResponseEntity.ok().body(branchService.update(request));
    }

    @ApiOperation(value = "가게 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteBranch(DeleteRemoveReq request) {
        return ResponseEntity.ok().body(branchService.delete(request));
    }


}
