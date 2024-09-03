package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;


@RestController //Está indicando que essa classe é um controlador que fornece dados por uma API REST.
@RequestMapping(value = "/categories") // Está indicando que os métodos dentro da classe vão responder ulrs que começam com "CategoryS"
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	//Pro springboot entender 
	@GetMapping //Ele é chamado quando uma requisição URL com "/Categorys" for feita.
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //isso aqui é pra usar o Id de forma dinamica.
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
