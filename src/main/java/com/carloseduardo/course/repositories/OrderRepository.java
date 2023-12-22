package com.carloseduardo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carloseduardo.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
