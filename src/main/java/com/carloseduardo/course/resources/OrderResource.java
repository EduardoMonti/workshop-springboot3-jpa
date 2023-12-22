package com.carloseduardo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.course.entities.Order;
import com.carloseduardo.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	// Implementação dos endpoints

	// Injeção de dependência do OrderService
	@Autowired
	private OrderService service;

	// Retorna todos os usuários
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Retorna o usuário pela id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
