package com.oak.wshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oak.wshop.dto.UserDTO;
import com.oak.wshop.model.User;
import com.oak.wshop.repository.UserRepository;
import com.oak.wshop.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findByID(String id) {
		Optional<User> user = repository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;

	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findByID(id);
		repository.deleteById(id);
	}
}
