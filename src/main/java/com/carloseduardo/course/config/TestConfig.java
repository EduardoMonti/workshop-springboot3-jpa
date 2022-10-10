package com.carloseduardo.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carloseduardo.course.entities.User;
import com.carloseduardo.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner	 {
	
	@Autowired
	private UserRepository userRepository;
    
	
	
	//Tudo que estiver no método será executado quando a aplicação rodar
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Grogu", "grogu@gmail.com", "99991010", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	

}
