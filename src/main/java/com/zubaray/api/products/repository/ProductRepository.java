package com.zubaray.api.products.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zubaray.api.products.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    Page<Product> findAll(Pageable pageable);
}
