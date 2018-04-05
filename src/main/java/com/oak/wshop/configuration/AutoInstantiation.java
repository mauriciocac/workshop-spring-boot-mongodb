package com.oak.wshop.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.oak.wshop.dto.AuthorDTO;
import com.oak.wshop.model.Post;
import com.oak.wshop.model.User;
import com.oak.wshop.repository.PostRepository;
import com.oak.wshop.repository.UserRepository;

@Configuration
public class AutoInstantiation implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User aidil = new User(null, "Aidil Carvalho", "aidil.cac@hotmail.com");
		User mari = new User(null, "Mariana Carvalho", "mariana.cac@hotmail.com");
		User fran = new User(null, "Francisco Casaes", "francisco.cac@hotmail.com");
		User mau = new User(null, "Mauricio Carvalho", "mauricio.cac@hotmail.com");
		User jhes = new User(null, "Jhessilly Alvim", "jhessilly.alvim@hotmail.com");
		User gil = new User(null, "Gil Alvim", "gil.alvim@hotmail.com");
		User joao = new User(null, "Joao Alvim", "joao.alvim@hotmail.com");

		userRepository.saveAll(Arrays.asList(mau, aidil, mari, fran, jhes, gil, joao));

		
		Post post1 = new Post(null, sdf.parse("21/03/2018 21:10:25"), "Partiu Viagem!", "Irei viajar para Santos.", new AuthorDTO(aidil));
		Post post2 = new Post(null, sdf.parse("21/03/2018 21:10:30"), "Bom dia!", "Acordei muito feliz hoje.", new AuthorDTO(aidil));

		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
