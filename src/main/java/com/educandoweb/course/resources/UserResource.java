package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //Está indicando que essa classe é um controlador que fornece dados por uma API REST.
@RequestMapping(value = "/users") // Está indicando que os métodos dentro da classe vão responder ulrs que começam com "USERS"
public class UserResource {

	//Pro springboot entender 
	@GetMapping //Ele é chamado quando uma requisição URL com "/users" for feita.
	public ResponseEntity<User> findAll() {
		//Botou o L pq é long no contructos
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
