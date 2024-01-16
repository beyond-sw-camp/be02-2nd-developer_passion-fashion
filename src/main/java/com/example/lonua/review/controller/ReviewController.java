package com.example.lonua.review.controller;

import com.example.lonua.common.BaseRes;
import com.example.lonua.review.model.request.*;
import com.example.lonua.review.service.ReviewService;
<<<<<<< HEAD
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
=======
import com.example.lonua.user.model.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
>>>>>>> develop
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
>>>>>>> develop

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Api(value="리뷰 컨트롤러 v1", tags="리뷰 API")
public class ReviewController {

    private final ReviewService reviewService;
<<<<<<< HEAD
    @ApiOperation(value = "리뷰 등록")
=======

    @ApiOperation(value = "리뷰 등록", response = BaseRes.class, notes = "회원은 구매한 상품에 대한 리뷰를 작성할 수 있다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
>>>>>>> develop
    @RequestMapping(method = RequestMethod.POST, value = "/register")
<<<<<<< HEAD
    public ResponseEntity registReview(
            @RequestPart(value = "review") @Valid PostRegisterReviewReq postRegisterReviewReq,
            @RequestPart(value = "reviewPhoto") @NotNull MultipartFile file
    ) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = reviewService.registerReview(user, postRegisterReviewReq, file);

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "리뷰 조회", response = BaseRes.class, notes = "회원은 상품에 대한 리뷰를 조회할 수 있다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/read/{reviewIdx}")
    public ResponseEntity readReview(@PathVariable @NotNull @Positive Integer reviewIdx) {
        BaseRes baseRes = reviewService.readReview(reviewIdx);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "리뷰 목록 조회", response = BaseRes.class, notes = "회원은 상품에 대한 전체 리뷰를 조회할 수 있다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })

    @RequestMapping(method = RequestMethod.GET, value = "/list/{productIdx}")
    public ResponseEntity listReview(@PathVariable @NotNull @Positive Integer productIdx) {
        BaseRes baseRes = reviewService.listReview(productIdx);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "등록한 리뷰 수정", response = BaseRes.class, notes = "회원은 등록한 리뷰를 수정할 수 있다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateReview(
            @RequestPart(value = "review") @Valid PatchUpdateReviewReq request,
            @RequestPart(value = "reviewPhoto") @NotNull MultipartFile reviewFile) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = reviewService.updateReview(request, reviewFile, user);

        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "등록한 리뷰 삭제", response = BaseRes.class, notes = "회원은 등록한 리뷰를 삭제할 수 있다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{reviewIdx}")
<<<<<<< HEAD
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
=======
    public ResponseEntity deleteReview(@PathVariable @NotNull @Positive Integer reviewIdx) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes =  reviewService.deleteReview(reviewIdx, user);

>>>>>>> develop
        return ResponseEntity.ok().body(baseRes);
    }
}
