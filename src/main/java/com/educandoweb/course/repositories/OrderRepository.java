package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

//Ta criando a interface que usa Orders do tipo Long
//Poderia colocar um @Repository aqui, mas como ela já herda o JPA repository nn é obrigatório
public interface OrderRepository extends JpaRepository<Order, Long> {

	//O SpringJPA já tem uma implementação base dessa interface, só precisa passar 
	//O que vai usar (Order, Long) que você tem acesso a ela.
}
