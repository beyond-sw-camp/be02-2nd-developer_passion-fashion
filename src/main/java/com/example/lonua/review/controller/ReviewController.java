package com.example.lonua.review.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.review.model.request.*;
import com.example.lonua.review.service.ReviewService;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registReview(
            @RequestPart(value = "review") PostRegisterReviewReq postRegisterReviewReq,
            @RequestPart(value = "reviewPhoto") MultipartFile file
    ) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = reviewService.registerReview(user, postRegisterReviewReq,file);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{reviewIdx}")
    public ResponseEntity readReview(@PathVariable Integer reviewIdx) {
        BaseRes baseRes = reviewService.readReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list/{productIdx}")
    public ResponseEntity listReview(@PathVariable Integer productIdx) {
        BaseRes baseRes = reviewService.listReview(productIdx);
        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateReview(@RequestBody PatchUpdateReviewReq request) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = reviewService.updateReview(request, user);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{reviewIdx}")
    public ResponseEntity deleteReview(@PathVariable Integer reviewIdx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes =  reviewService.deleteReview(reviewIdx, user);

        return ResponseEntity.ok().body(baseRes);
    }
}
