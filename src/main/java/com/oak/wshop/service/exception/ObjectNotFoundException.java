package com.oak.wshop.service.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
//Classe de escessão para os usuários que não forem encontrados. Cria uma classe auxiliar para tratar a excessão
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
}
