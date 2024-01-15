package com.example.lonua.likes.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.likes.model.request.PostCancelLikesReq;
import com.example.lonua.likes.service.LikesService;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    @RequestMapping(method = RequestMethod.GET, value = "/{idx}")
    public ResponseEntity createLikes(@PathVariable Integer idx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        try {
            return ResponseEntity.ok().body(likesService.createLikes(user, idx));
        } catch (Exception e) {
            return ResponseEntity.ok().body("동시성 에러 발생");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = likesService.list(user);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cancel")
    public ResponseEntity in(@RequestBody PostCancelLikesReq postCancelLikesReq) {
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = likesService.cancle(user, postCancelLikesReq);

        return ResponseEntity.ok().body(baseRes);
    }
}
