package com.example.lonua.likes.controller;


import com.example.lonua.config.BaseRes;
import com.example.lonua.likes.model.request.PostCancelLikesReq;
import com.example.lonua.likes.service.LikesService;
import com.example.lonua.user.model.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    @ApiOperation(value = "좋아요 누른 상품 등록하기")
    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity createLikes(@PathVariable @Min(value = 1) Integer idx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        try {
            likesService.createLikes(user, idx);
        } catch (Exception e) {
            System.out.println("동시성 에러 발생");
        }
        return ResponseEntity.ok().body(BaseRes.builder()
                        .code(200)
                        .isSuccess(true)
                        .message("요청 성공")
                        .result("좋아요를 추가하였습니다.")
                .build());
    }
    @ApiOperation(value = "좋아요 누른 상품 목록 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = likesService.list(user);

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "좋아요 누른 상품 삭제하기")
    @RequestMapping(method = RequestMethod.POST, value = "/cancel")
    public ResponseEntity in(@RequestBody @Valid PostCancelLikesReq postCancelLikesReq) { // 메소드 이름의 상태가?
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = likesService.cancle(user, postCancelLikesReq);

        return ResponseEntity.ok().body(baseRes);
    }
}
