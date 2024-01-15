package com.example.lonua.user.controller;

import com.example.lonua.common.BaseRes;
import com.example.lonua.user.model.entity.User;
import com.example.lonua.user.model.entity.request.*;
import com.example.lonua.user.service.EmailVerifyService;
import com.example.lonua.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value="회원 컨트롤러 v1", tags="회원 API")
public class UserController {

    private final UserService userService;
    private final EmailVerifyService emailVerifyService;

    @ApiOperation("회원 가입")
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(@RequestBody PostSignUpReq postSignUpReq) {
        BaseRes baseRes = userService.signup(postSignUpReq);

        // 인증메일 발송
        userService.sendEmail(postSignUpReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation("이메일 인증")
    @RequestMapping(method = RequestMethod.GET, value = "/verify")
    public ResponseEntity verify(@RequestBody GetEmailVerifyReq getEmailVerifyReq) {
        if (emailVerifyService.verify(getEmailVerifyReq)) {
            BaseRes baseRes = userService.updateStatus(getEmailVerifyReq.getEmail()); // 이메일 인증이 완료되면 회원의 status를 바꿔줌
            return ResponseEntity.ok().body(baseRes);
        } else {
            return ResponseEntity.ok().body(BaseRes.builder()
                            .code(400)
                            .isSuccess(false)
                            .message("메일 인증을 다시 진행해주세요.")
                            .result("인증에 실패하였습니다.")
                    .build());
        }
    }

    @ApiOperation("로그인")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody PostUserLoginReq postUserLoginReq) {

        BaseRes baseRes = userService.login(postUserLoginReq);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation("회원 목록 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {

        BaseRes baseRes = userService.list();
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation("특정 회원 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read() {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = userService.read(user.getUserEmail());

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation("회원 정보 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody PatchUserUpdateReq patchUserUpdateReq) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        BaseRes baseRes = userService.update(user.getUserEmail(), patchUserUpdateReq);

        return ResponseEntity.ok().body(baseRes);
    }


    @ApiOperation("회원 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{userIdx}")
    public ResponseEntity delete(@PathVariable Integer userIdx) {

        BaseRes baseRes = userService.delete(userIdx);

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation("회원 탈퇴")
    @RequestMapping(method = RequestMethod.GET, value = "/cancle")
    public ResponseEntity cancle() {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return ResponseEntity.ok().body(userService.cancle(user));
    }
}
