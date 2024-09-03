package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//Service depende de Data Access, Resource Depente de Service, e Appl usa o Resource
@Service //Isso torna essa classe um serviço do String para ser injetada diretamente com o autowired
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		//Já tem esse método na implementação default de ProductRepository
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		//De novo puxando uma função de Repository
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
