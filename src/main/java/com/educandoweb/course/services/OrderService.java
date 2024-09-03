package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//Service depende de Data Access, Resource Depente de Service, e Appl usa o Resource
@Service //Isso torna essa classe um serviço do String para ser injetada diretamente com o autowired
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		//Já tem esse método na implementação default de OrderRepository
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		//De novo puxando uma função de Repository
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
