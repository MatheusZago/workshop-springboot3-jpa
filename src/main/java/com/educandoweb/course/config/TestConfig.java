package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration //Para o Spring saber que é uma classe especificamente de configuração.
@Profile("test") //É especifica para perfil de teste.
public class TestConfig implements CommandLineRunner {
	
	@Autowired //Está criando uma dependência com o Spring (ao invés de chamar construtor ou método fabrica)
	private UserRepository userRepository;

	//Veio do CommandLineRunner, isso vai ser executado assim que a app for iniciada.
	@Override
	public void run(String... args) throws Exception {
		//id é nulo pois ele é implmenetado pelo banco de dados.
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		//Adicionando eles no banco de dados, estão sendo usados como uma lista
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	
}
