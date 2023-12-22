package com.carloseduardo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.course.entities.Order;
import com.carloseduardo.course.repositories.OrderRepository;

/*Anotation 'Service' utilizado para registrar a classe como componente do Spring, onde ela vai poder ser injetada automaticamente
  no Resource com o 'Autowired' */
@Service
public class OrderService {

	// Injeção de dependência do repository
	@Autowired
	private OrderRepository repository;

	// Buscando todo os usuários
	public List<Order> findAll() {
		return repository.findAll();
	}

	// Buscando usuário por id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
