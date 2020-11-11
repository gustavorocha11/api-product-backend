package com.zubaray.api.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubaray.api.products.model.Product;
import com.zubaray.api.products.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository repository;

    @GetMapping("/findAll")
    public Page<Product> findAll(Integer page, Integer size) {
        logger.info("Get all products...");
        page = page != null ? page : 0;
        size = size != null ? size : 10;
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        return repository.findAll(pageable);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        logger.info("Creating a new products...");
        logger.info("{}", product);
        if(product.isValid()) {
            return repository.save(product);
        } else {
            return product;
        }
    }
}
