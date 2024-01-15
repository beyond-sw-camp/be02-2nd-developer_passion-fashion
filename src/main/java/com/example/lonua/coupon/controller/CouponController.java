package com.example.lonua.coupon.controller;

import com.example.lonua.coupon.model.request.DeleteRemoveReq;
import com.example.lonua.coupon.model.request.GetReadReq;
import com.example.lonua.coupon.model.request.PostRegisterReq;
import com.example.lonua.coupon.service.CouponService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;


    @ApiOperation(value = "쿠폰 등록하기",httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerCoupon(@RequestBody @Valid PostRegisterReq request) {
        return ResponseEntity.ok().body(couponService.create(request));
    }

    @ApiOperation(value = "쿠폰 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listCoupon() {
        return ResponseEntity.ok().body(couponService.list());
    }

    @ApiOperation(value = "쿠폰 하나 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity readCoupon(@RequestBody @Valid GetReadReq request) {
        return ResponseEntity.ok().body(couponService.read(request));
    }

    @ApiOperation(value = "쿠폰 하나 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteCoupon(@RequestBody @Valid DeleteRemoveReq request) {
        return ResponseEntity.ok().body(couponService.delete(request));
    }


}
