package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;


@RestController //Está indicando que essa classe é um controlador que fornece dados por uma API REST.
@RequestMapping(value = "/users") // Está indicando que os métodos dentro da classe vão responder ulrs que começam com "USERS"
public class UserResource {
	
	@Autowired
	private UserService service;

	//Pro springboot entender 
	@GetMapping //Ele é chamado quando uma requisição URL com "/users" for feita.
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //Ela aceita um id dinamico
	public ResponseEntity<User> findById(@PathVariable Long id ){//PathVariable quer dizer que ele aceita o id do GetMapping
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //Retornando o obj
	}
	
	
}
