package com.example.lonua.cart.repository;

import com.example.lonua.cart.model.entity.Cart;
import com.example.lonua.cart.repository.querydsl.CartRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer>, CartRepositoryCustom {

    @Modifying
    @Query("DELETE FROM Cart c where c.user.userIdx = :userIdx")
    void deleteByUserIdx(Integer userIdx);
}
