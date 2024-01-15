package com.example.lonua.orders.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.orders.model.request.PostCreateOrdersReq;
import com.example.lonua.orders.service.OrdersService;
import com.example.lonua.user.model.entity.User;
<<<<<<< HEAD
=======
import com.siot.IamportRestClient.exception.IamportResponseException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
>>>>>>> feature/swagger
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;

>>>>>>> feature/swagger
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;
    @ApiOperation(value = "주문 정보 등록하기")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(@RequestBody @Valid PostCreateOrdersReq postCreateOrdersReq){

        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.createOrder(user, postCreateOrdersReq);

        return ResponseEntity.ok().body(baseRes);
    }
<<<<<<< HEAD

    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size){
=======
    @ApiOperation(value = "주문 정보 목록 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list(@ApiParam(value = "page") @Min(value = 1) Integer page, @ApiParam(value = "size") @Max(value = 40) Integer size){
>>>>>>> feature/swagger
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.list(user, page, size);
        return ResponseEntity.ok().body(baseRes);
    }

    @ApiOperation(value = "주문 하나의 상세 정보 조회하기")
    @RequestMapping(method = RequestMethod.GET, value = "/read/{idx}")
    public ResponseEntity read(@PathVariable @Min(value = 1) Integer idx){
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.read(user, idx);

        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "주문 하나 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancle/{idx}")
    public ResponseEntity delete(@PathVariable @Min(value = 1) Integer idx) {
        BaseRes baseRes = ordersService.delete(idx);
        return ResponseEntity.ok().body(baseRes);
    }

    // ---------------------카카오페이 결제를 통한 주문-----------------------------
//    @RequestMapping(method = RequestMethod.POST, value = "/create")
//    public ResponseEntity create(@RequestBody PostCreateOrdersReq postCreateOrdersReq) throws IamportResponseException, IOException {
//
//        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        BaseRes baseRes = ordersService.paymentValidation(user, postCreateOrdersReq);
//
//        return ResponseEntity.ok().body(baseRes);
//    }
    // --------------------------------------------------------------------------
}
