package com.example.lonua.review.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.review.model.request.*;
import com.example.lonua.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    @ApiOperation(value = "리뷰 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
<<<<<<< HEAD
    public ResponseEntity registReview(
            @RequestPart(value = "review") PostRegisterReviewReq postRegisterReviewReq,
            @RequestPart(value = "reviewPhoto") MultipartFile file
    ) {
        BaseRes baseRes = reviewService.registerReview(postRegisterReviewReq,file);
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
    public ResponseEntity updateReview(@RequestBody UpdateReviewReq request) {
        BaseRes baseRes = reviewService.updateReview(request);
        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{reviewIdx}")
    public ResponseEntity deleteReview(@PathVariable Integer reviewIdx) {
=======
    public ResponseEntity register(@Valid PostReviewReq request) {
        BaseRes baseRes = reviewService.registerReview(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity readReview(@ApiParam(value = "리뷰 idx") @Valid Integer reviewIdx) {
        BaseRes baseRes = reviewService.readReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateReview(@Valid PostReviewReq request) {
        BaseRes baseRes = reviewService.updateReview(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteReview(@ApiParam(value = "리뷰 idx") @Valid Integer reviewIdx) {
>>>>>>> feature/swagger
        BaseRes baseRes =  reviewService.deleteReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }
}
