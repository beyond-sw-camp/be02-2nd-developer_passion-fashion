package com.example.lonua.question.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.question.model.request.PatchUpdateQuestionReq;
import com.example.lonua.question.model.request.PostRegisterQuestionReq;
import com.example.lonua.question.service.QuestionService;
<<<<<<< HEAD
import com.example.lonua.user.model.entity.User;
=======
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
>>>>>>> feature/swagger
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    @ApiOperation(value = "질문 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
<<<<<<< HEAD
    public ResponseEntity register(@RequestBody PostRegisterQuestionReq postRegisterQuestionReq) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.register(user, postRegisterQuestionReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.list(user, page, size);

=======
    public ResponseEntity registerQuestion(@Valid PostQuestionReq request) {
        BaseRes baseRes = questionService.registerQuestion(request);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "질문 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity readQuestion(@ApiParam(name = "질문 식별 번호", value = "1이상의 양수") @Valid Integer questionIdx) {
        BaseRes baseRes = questionService.readQuestion(questionIdx);
>>>>>>> feature/swagger
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "질문 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
<<<<<<< HEAD
    public ResponseEntity update(@RequestBody PatchUpdateQuestionReq patchUpdateQuestionReq) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.update(user, patchUpdateQuestionReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable Integer idx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.delete(idx, user);

=======
    public ResponseEntity updateQuestion(@Valid PostQuestionReq request) {
        BaseRes baseRes = questionService.updateQuestion(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "질문 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteQuestion(@ApiParam(name = "질문 Idx", value = "질문 Idx 숫자") @Valid Integer questionIdx) {
        BaseRes baseRes = questionService.deleteQuestion(questionIdx);
>>>>>>> feature/swagger
        return ResponseEntity.ok().body(baseRes);
    }

}
