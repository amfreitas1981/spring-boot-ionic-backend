package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cidade implements Serializable{

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	// A relação está bem clara no diagrama. No papel, temos um Estado para muitas cidades. Portanto, não teremos lista...
	// Na classe Cidade, inserir a anotação @ManyToOne, importada de: javax.persistence, que serve para fazer a relação de "muitas cidades para um estado"...
	// Adicionar a anotação @JsonManagedReference...
	// @JsonManagedReference
	@ManyToOne
	// Inserir a anotação @JoinColumn, para fazer a junção das tabelas e criar uma chave primária...
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	public Cidade() {
	}

	// Criar os construtores (sem coleções nos parâmetros)...
	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	// Criar os construtores Getters e Setters...
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// Criar hashCode() e equals()... Somente "id"!!!
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
}
