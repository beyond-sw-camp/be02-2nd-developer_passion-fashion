package com.example.lonua.cart.controller;



import com.example.lonua.cart.model.request.DeleteRemoveReq;
import com.example.lonua.cart.model.request.PostRegisterReq;
import com.example.lonua.cart.service.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    @ApiOperation(value = "장바구니에 상품 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerCart(PostRegisterReq request) {
        return ResponseEntity.ok().body(cartService.create(request));
    }
    @ApiOperation(value = "장바구니 상품 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity listCart(Integer page, Integer size) {
        return ResponseEntity.ok().body(cartService.list(page, size));
    }
    @ApiOperation(value = "장바구니 상품 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteCart(@ApiParam(value = "삭제할 장바구니") DeleteRemoveReq request) {
        return ResponseEntity.ok().body(cartService.delete(request));
    }

    @ApiOperation(value = "장바구니 상품 모두 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
    ResponseEntity deleteCart() {
        return ResponseEntity.ok().body(cartService.deleteAll());
    }
}
