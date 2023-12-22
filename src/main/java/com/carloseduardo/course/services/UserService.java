package com.carloseduardo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.carloseduardo.course.entities.User;
import com.carloseduardo.course.repositories.UserRepository;
import com.carloseduardo.course.services.exceptions.DatabaseException;
import com.carloseduardo.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

/*Anotation 'Service' utilizado para registrar a classe como componente do Spring, onde ela vai poder ser injetada automaticamente
  no Resource com o 'Autowired' */
@Service
public class UserService {
	
	//Injeção de dependência do repository
	@Autowired
	private UserRepository userRepository;
	
	//Buscando todo os usuários
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	//Buscando usuário por id 
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//salvando novo usuário
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	//deletando usuário
	 public void delete (long id) {
		 try {
			 userRepository.deleteById(id);
		 } catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		 } catch (DataIntegrityViolationException e) {
			 throw new DatabaseException(e.getMessage()); //Lançando a excessão da camada de serviço
		 }
		
	 }
	 
	 //atualizando usuário
	 public User update (Long id, User obj) {
		 try {
			 User entity = userRepository.getReferenceById(id);
			 updateData(entity, obj);
			 return userRepository.save(entity);
		 } catch(EntityNotFoundException e) {
			 throw new ResourceNotFoundException(id);
		 }
		
	 }

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
