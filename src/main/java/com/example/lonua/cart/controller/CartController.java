package com.example.lonua.cart.controller;



import com.example.lonua.cart.model.request.DeleteAllRemoveReq;
import com.example.lonua.cart.model.request.DeleteRemoveReq;
import com.example.lonua.cart.model.request.PostRegisterReq;
import com.example.lonua.cart.service.CartService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;


    @ApiOperation(value = "장바구니에 상품 등록")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity registerCart(@RequestBody PostRegisterReq request) {
        return ResponseEntity.ok().body(cartService.create(request));
    }

    @ApiOperation(value = "장바구니 상품 목록 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    ResponseEntity listCart(Integer userIdx, @PathVariable Integer page,@PathVariable Integer size) {
        return ResponseEntity.ok().body(cartService.list(userIdx, page, size));
    }

    @ApiOperation(value = "장바구니 상품 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity deleteCart(@RequestBody DeleteRemoveReq request) {
        return ResponseEntity.ok().body(cartService.delete(request));
    }

    @ApiOperation(value = "장바구니 상품 모두 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteall")
    ResponseEntity deleteCart(@RequestBody DeleteAllRemoveReq request) {
        return ResponseEntity.ok().body(cartService.deleteAll(request));
    }
}
