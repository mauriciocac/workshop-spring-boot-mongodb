package com.oak.wshop.dto;

import java.io.Serializable;
import java.util.Optional;

import com.oak.wshop.model.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String email;

	public UserDTO() {
	}

 
	public UserDTO(User user) {
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
