package com.manhcode.jpa.demo;

import com.manhcode.jpa.demo.coupon.entity.Coupon;
import com.manhcode.jpa.demo.coupon.repository.CouponRepository;
import com.manhcode.jpa.demo.product.entity.Product;
import com.manhcode.jpa.demo.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreate() {
        Coupon coupon =new Coupon("SUPERSALE", new BigDecimal(20), "22/02/2022");
        couponRepository.save(coupon);
        System.out.println(coupon);
    }

    @Test
    public void testCreate2() {
        Product product = new Product("Macbook", "Cool", new BigDecimal(2000));
        productRepository.save(product);
        System.out.println(product);
    }
}
