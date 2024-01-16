package com.example.lonua.cart.service;

import com.example.lonua.cart.model.entity.Cart;
import com.example.lonua.cart.model.request.DeleteAllCartRemoveReq;
import com.example.lonua.cart.model.request.DeleteCartRemoveReq;
import com.example.lonua.cart.model.request.PostCartRegisterReq;
import com.example.lonua.cart.model.response.GetCartListRes;
import com.example.lonua.cart.model.response.PostCartRegisterRes;
import com.example.lonua.cart.repository.CartRepository;
import com.example.lonua.common.BaseRes;
import com.example.lonua.product.model.entity.Product;
import com.example.lonua.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public BaseRes create(PostCartRegisterReq request) {
        Cart cart = cartRepository.save(Cart.builder()
                .user(User.builder()
                        .userIdx(request.getUserIdx())
                        .build())
                .product(Product.builder()
                        .productIdx(request.getProductIdx())
                        .build())
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .status(false)
                .build());

        return BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("요청 성공")
                .result(PostCartRegisterRes.builder()
                        .cartIdx(cart.getCartIdx())
                        .createdAt(cart.getCreatedAt())
                        .updatedAt(cart.getUpdatedAt())
                        .userIdx(cart.getUser().getUserIdx())
                        .productIdx(cart.getProduct().getProductIdx())
                        .status(cart.getStatus())
                        .build())
                .build();
    }

    public BaseRes list(Integer userIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Cart> all = cartRepository.findList(pageable, userIdx);
        List<GetCartListRes> getListResCartList = new ArrayList<>();

        for (Cart cart : all) {
            GetCartListRes build = GetCartListRes.builder()
                    .cartIdx(cart.getCartIdx())
                    .productName(cart.getProduct().getProductName())
                    .price(cart.getProduct().getPrice())
                    .build();
            getListResCartList.add(build);
        }

        return BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("요청 성공")
                .result(getListResCartList)
                .build();
    }

    public BaseRes delete(DeleteCartRemoveReq request) {

        Cart cart = Cart.builder()
                .cartIdx(request.getCartIdx())
                .build();

        cartRepository.delete(cart);

        return BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("장바구니 1개 상품 삭제 성공")
                .result("요청 성공")
                .build();
    }

    @Transactional
    public BaseRes deleteAll(DeleteAllCartRemoveReq request) {

        cartRepository.deleteByUserIdx(request.getUserIdx());

        return BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("장바구니 전체 상품 삭제 성공")
                .result("요청 성공")
                .build();
    }
}
