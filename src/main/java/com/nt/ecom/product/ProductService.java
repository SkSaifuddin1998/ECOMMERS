package com.nt.ecom.product;

import org.springframework.stereotype.Service;

import com.nt.ecom.observer.EventManager;
import com.nt.ecom.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product product) {

        Product saved = repository.save(product);

        EventManager eventManager =
                new EventManager();

        eventManager.notifyAllListeners(
                "PRODUCT_CREATED",
                product.getProductName());

        return saved;
    }
}