package com.example.lonua.review.controller;


import com.example.lonua.config.BaseRes;
import com.example.lonua.review.model.request.PostReviewReq;
import com.example.lonua.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    @ApiOperation(value = "리뷰 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(PostReviewReq request) {
        BaseRes baseRes = reviewService.registerReview(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity readReview(@ApiParam(value = "리뷰 idx") Integer reviewIdx) {
        BaseRes baseRes = reviewService.readReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 수정")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateReview(PostReviewReq request) {
        BaseRes baseRes = reviewService.updateReview(request);
        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "리뷰 삭제")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteReview(@ApiParam(value = "리뷰 idx") Integer reviewIdx) {
        BaseRes baseRes =  reviewService.deleteReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }
}
