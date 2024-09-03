package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//Service depende de Data Access, Resource Depente de Service, e Appl usa o Resource
@Service //Isso torna essa classe um serviço do String para ser injetada diretamente com o autowired
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		//Já tem esse método na implementação default de CategoryRepository
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		//De novo puxando uma função de Repository
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
