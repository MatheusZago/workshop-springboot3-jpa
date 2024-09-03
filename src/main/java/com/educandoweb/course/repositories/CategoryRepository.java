package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

//Ta criando a interface que usa Categorys do tipo Long
//Poderia colocar um @Repository aqui, mas como ela já herda o JPA repository nn é obrigatório
public interface CategoryRepository extends JpaRepository<Category, Long> {

	//O SpringJPA já tem uma implementação base dessa interface, só precisa passar 
	//O que vai usar (Category, Long) que você tem acesso a ela.
}
