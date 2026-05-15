package com.nt.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.ecom.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}