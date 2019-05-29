package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Produto implements Serializable{

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double preco;
	
	// Implementar a representação, respeitando o nome que consta no papel, tratados neste caso, como uma lista...
	@ManyToMany // Para fazer a relação muitos para muitos, que pode ser adiciona em um dos lados da relação...
	// Para fazer a relação dos "id" das duas tabelas...
	@JoinTable(name = "PRODUTO_CATEGORIA", 
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	// O name, pode ser o nome que quiser colocar...
	// joinColumns é a chave estrangeira para onde vamos receber, aplicado na anotação @JoinColumn (importado de javax.persistence), criando um nome à sua escolha...
	// inverseJoinColumns é a chave estrangeira de onde vamos enviar, aplicado na anotação @JoinColumn, criando um nome à sua escolha...
	private List<Categoria> categorias = new ArrayList<>();
	
	// Incluir construtores...
	public Produto() {
	}

	// Incluir construtor com parâmetros e argumentos... Todos, menos "categorias", porque já foi declarado acima...
	public Produto(Integer id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	// Incluir Getters e Setters (todos os campos)...
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	// Criar hashCode() e equals(), considerando somente o "id"...
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
