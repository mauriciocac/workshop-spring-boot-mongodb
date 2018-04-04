package com.oak.wshop.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oak.wshop.dto.UserDTO;
import com.oak.wshop.model.User;
import com.oak.wshop.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping
	@RequestMapping(value = "usuarios")
	public ResponseEntity<List<UserDTO>> listarTodos() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> findByID(@PathVariable String id) {
		Optional<User> user = service.findByID(id);
		return ResponseEntity.ok().body( user) ;
	}
}
