package com.example.lonua.orders.controller;


import com.example.lonua.common.BaseRes;
import com.example.lonua.orders.model.request.PostCreateOrdersReq;
import com.example.lonua.orders.service.OrdersService;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(@RequestBody PostCreateOrdersReq postCreateOrdersReq){

        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.createOrder(user, postCreateOrdersReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list/{page}/{size}")
    public ResponseEntity list(@PathVariable Integer page, @PathVariable Integer size){
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.list(user, page, size);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{idx}")
    public ResponseEntity read(@PathVariable Integer idx){
        User user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        BaseRes baseRes = ordersService.read(user, idx);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancle/{idx}")
    public ResponseEntity delete(@PathVariable Integer idx) {
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
