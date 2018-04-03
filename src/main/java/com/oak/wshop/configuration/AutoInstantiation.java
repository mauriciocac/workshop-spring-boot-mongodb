package com.oak.wshop.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.oak.wshop.model.User;
import com.oak.wshop.repository.UserRepository;

@Configuration
public class AutoInstantiation implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		User aidil = new User(null, "Aidil Carvalho", "aidil.cac@hotmail.com");
		User mari = new User(null, "Mariana Carvalho", "mariana.cac@hotmail.com");
		User fran = new User(null, "Francisco Casaes", "francisco.cac@hotmail.com");
		User mau = new User(null, "Mauricio Carvalho", "mauricio.cac@hotmail.com");
		User jhes = new User(null, "Jhessilly Alvim", "jhessilly.alvim@hotmail.com");
		User gil = new User(null, "Gil Alvim", "gil.alvim@hotmail.com");

		userRepository.saveAll(Arrays.asList(mau, aidil, mari, fran, jhes, gil));
	}

}
