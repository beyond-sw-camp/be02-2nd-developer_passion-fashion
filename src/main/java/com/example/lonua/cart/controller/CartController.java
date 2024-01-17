package com.example.lonua.cart.controller;



import com.example.lonua.cart.model.request.DeleteAllCartRemoveReq;
import com.example.lonua.cart.model.request.DeleteCartRemoveReq;
import com.example.lonua.cart.model.request.PostCartRegisterReq;
import com.example.lonua.cart.service.CartService;

import com.example.lonua.common.BaseRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
@Api(value="장바구니 컨트롤러 v1", tags="장바구니 API")
public class CartController {
    private final CartService cartService;

    @ApiOperation(value = "장바구니 추가", response = BaseRes.class, notes = "회원이 장바구니에 물건을 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK ( 요청 성공 )", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRes.class)) }) })

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerCart(@RequestBody PostCartRegisterReq request) {
        return ResponseEntity.ok().body(cartService.create(request));
    }

    @ApiOperation(value = "장바구니 상품 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listCart(Integer page, Integer size) {
        return ResponseEntity.ok().body(cartService.list(page, size));

    }
    ResponseEntity deleteCart(@ApiParam(value = "삭제할 장바구니") DeleteRemoveReq request) {
        return ResponseEntity.ok().body(cartService.delete(request));
    }
    @ApiOperation(value = "장바구니 상품 모두 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
    ResponseEntity deleteCart() {
        return ResponseEntity.ok().body(cartService.deleteAll());
    }
}
