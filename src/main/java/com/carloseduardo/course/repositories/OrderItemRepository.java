package com.carloseduardo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carloseduardo.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
