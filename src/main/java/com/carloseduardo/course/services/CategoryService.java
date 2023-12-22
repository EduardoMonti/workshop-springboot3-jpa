package com.carloseduardo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.course.entities.Category;
import com.carloseduardo.course.repositories.CategoryRepository;

/*Anotation 'Service' utilizado para registrar a classe como componente do Spring, onde ela vai poder ser injetada automaticamente
  no Resource com o 'Autowired' */
@Service
public class CategoryService {
	
	//Injeção de dependência do repository
	@Autowired
	private CategoryRepository repository;
	
	//Buscando todo as categorias
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//Buscando categoria por id 
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
