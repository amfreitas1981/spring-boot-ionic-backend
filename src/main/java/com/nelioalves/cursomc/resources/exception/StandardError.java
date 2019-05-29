package com.nelioalves.cursomc.resources.exception;

import java.io.Serializable;

// Incluir na implementação "implements Serializable"...
public class StandardError implements Serializable {
	
	// Adicionar a serial version...
	private static final long serialVersionUID = 1L;
	
	// Status do erro:
	private Integer status;
	// A mensagem de erro:
	private String msg;
	// Instante onde aconteceu o erro:
	private Long timeStamp;
	
	// Criar um construtor para ficar de ajustar:
	// Criar em: Generate Constructor using Fields (todos os campos selecionados)...
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	// Criar os getters e setters (todos os campos selecionados):
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
