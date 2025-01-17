package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

//Service depende de Data Access, Resource Depente de Service, e Appl usa o Resource
@Service //Isso torna essa classe um serviço do String para ser injetada diretamente com o autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		//Já tem esse método na implementação default de UserRepository
		return repository.findAll();
	}
	
	public User findById(Long id) {
		//De novo puxando uma função de Repository
		Optional<User> obj = repository.findById(id);
		 //Ele vai tentar dar um get, se não tiver ele da uma exceção.
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); //Novo getOne, ele instancia um usuário monitorado pelo JPA sem precisar mexer no BD direto
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
