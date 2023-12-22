package com.carloseduardo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carloseduardo.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
