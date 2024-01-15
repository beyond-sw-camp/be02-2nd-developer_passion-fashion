package com.example.lonua.question.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.question.model.request.PatchUpdateQuestionReq;
import com.example.lonua.question.model.request.PostRegisterQuestionReq;
import com.example.lonua.question.service.QuestionService;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(@RequestBody PostRegisterQuestionReq postRegisterQuestionReq) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.register(user, postRegisterQuestionReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.list(user, page, size);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody PatchUpdateQuestionReq patchUpdateQuestionReq) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.update(user, patchUpdateQuestionReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable Integer idx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = questionService.delete(idx, user);

        return ResponseEntity.ok().body(baseRes);
    }

}
