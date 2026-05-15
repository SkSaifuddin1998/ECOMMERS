package com.nt.ecom.product;

import com.nt.ecom.common.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String productName;

    private Double price;

    private Integer quantity;

    private String status;
}