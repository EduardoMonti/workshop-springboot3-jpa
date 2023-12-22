package com.carloseduardo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.course.entities.Category;
import com.carloseduardo.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	// Implementação dos endpoints

	// Injeção de dependência do CategoryService
	@Autowired
	private CategoryService service;

	// Retorna todos as categorias
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Retorna a categoria pela id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
