package com.manhcode.jpa.demo.coupon.repository;


import com.manhcode.jpa.demo.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
