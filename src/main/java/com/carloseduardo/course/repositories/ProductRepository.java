package com.carloseduardo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carloseduardo.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
