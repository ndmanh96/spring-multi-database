package com.manhcode.jpa.demo.product.repository;


import com.manhcode.jpa.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
