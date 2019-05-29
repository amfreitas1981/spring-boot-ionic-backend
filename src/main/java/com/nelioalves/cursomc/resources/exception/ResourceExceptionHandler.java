package com.nelioalves.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice // Colocar na anotação @ControllerAdvice, importada de: org.springframework.web.bind.annotation.ControllerAdvice...
public class ResourceExceptionHandler {
	
	// No manipulador de erros:
	// Criar um método (padrão do Controller Advice)
	// StandardError, retirada do "meu" pacote... Que é um objeto que contém a informação do erro... 
	// objectNotFound() seria o nome do objeto que criamos para receber uma exceção de ObjectNotFoundException criada do "meu" pacote "services.exceptions"...
	// HttpServletRequest, importada de: javax.servlet.http.HttpServletRequest...
	// São dados para controle da requisição...
	// Inserir anotação @ExceptionHandler, importando de: org.springframework.web.bind.annotation.ExceptionHandler, recebendo ObjectNotFoundException.class, para indicar que é um tratador de exceções... Concluindo as configurações do filtro... 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		// Instanciar objeto do tipo StandardError, para notificar o tipo de erro a ser tratado...
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		// Retorno. Quando houver erro HTTP, retornando o valor atribuído ao objeto "err":
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
		
	}
	
}
