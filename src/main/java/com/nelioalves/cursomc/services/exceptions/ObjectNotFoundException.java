package com.nelioalves.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Criar o construtor, reaproveitando a linguagem de estruturas do Java...
	public ObjectNotFoundException(String msg) {
		// Será chamada a super classe (RuntimeException)...
		super(msg);
	}
	
	// Outro construtor que recebe a carga da mensagem, para identificar a causa do erro para tratar como exception, acionando também a super classe...
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	// Considerados como tipo padrão para tratamento de exceções, voltados para o pacote implementado...

}
