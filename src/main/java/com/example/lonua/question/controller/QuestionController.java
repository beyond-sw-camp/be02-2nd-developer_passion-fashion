package com.example.lonua.question.controller;


import com.example.lonua.config.BaseRes;
import com.example.lonua.question.model.request.PostQuestionReq;
import com.example.lonua.question.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    @ApiOperation(value = "질문 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registerQuestion(@Valid PostQuestionReq request) {
        BaseRes baseRes = questionService.registerQuestion(request);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "질문 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity readQuestion(@ApiParam(name = "질문 식별 번호", value = "1이상의 양수") @Valid Integer questionIdx) {
        BaseRes baseRes = questionService.readQuestion(questionIdx);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "질문 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateQuestion(@Valid PostQuestionReq request) {
        BaseRes baseRes = questionService.updateQuestion(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "질문 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteQuestion(@ApiParam(name = "질문 Idx", value = "질문 Idx 숫자") @Valid Integer questionIdx) {
        BaseRes baseRes = questionService.deleteQuestion(questionIdx);
        return ResponseEntity.ok().body(baseRes);
    }

}
