package com.carloseduardo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.course.entities.Product;
import com.carloseduardo.course.repositories.ProductRepository;

/*Anotation 'Service' utilizado para registrar a classe como componente do Spring, onde ela vai poder ser injetada automaticamente
  no Resource com o 'Autowired' */
@Service
public class ProductService {
	
	//Injeção de dependência do repository
	@Autowired
	private ProductRepository repository;
	
	//Buscando todos os produtos
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//Buscando produto por id 
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
