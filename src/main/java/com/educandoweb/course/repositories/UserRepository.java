package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

//Ta criando a interface que usa Users do tipo Long
public interface UserRepository extends JpaRepository<User, Long> {

	//O SpringJPA já tem uma implementação base dessa interface, só precisa passar 
	//O que vai usar (User, Long) que você tem acesso a ela.
}
