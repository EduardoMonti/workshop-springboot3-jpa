package com.carloseduardo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.course.entities.Product;
import com.carloseduardo.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	// Implementação dos endpoints

	// Injeção de dependência do ProductService
	@Autowired
	private ProductService service;

	// Retorna todos os usuários
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Retorna o usuário pela id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
