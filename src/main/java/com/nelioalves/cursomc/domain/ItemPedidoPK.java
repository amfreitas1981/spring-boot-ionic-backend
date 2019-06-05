package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// Para indicar que esta classe é um subtipo, adiciona a anotação @Embeddable...
@Embeddable
public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	// Esta classe deverá ser do tipo implements Serializable, incluindo a versão padrão também... 
	// Criar a classe "ItemPedidoPK" no pacote domain. Será uma classe auxiliar, que vai servir como uma 'chave primária'...
	// Esta classe terá uma referência para Produto e Pedido...
	
	
	// Inserir as anotações @ManyToOne e @JoinColumn para cada atributo, indicando que a relação é um para um e qual a referência a ser aplicada...
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	// Não precisa criar construtor...
	
	// Criar Getters e Setters...
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	// Criar hashCode() e equals()...
	// Neste caso, não haverá id, mas devemos selecionar produto e pedido para haver a relação...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
}
