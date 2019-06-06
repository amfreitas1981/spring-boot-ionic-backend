package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable{

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	// Como fazer a relação no JPA?
	// Não existe um id próprio para fazer as relações, mas sim, dois elementos associados para se relacionarem...
	// Neste caso, ItemPedido, no diagrama, é formado a partir das relações entre Produto e Pedido...
	// Forma rigorosa: Conter uma chave composta, contendo Produto e Pedido...
	// Criar a classe "ItemPedidoPK" no pacote domain. Será uma classe auxiliar, que vai servir como uma 'chave primária'...
	// Esta classe terá uma referência para Produto e pedido...
	
	// A classe auxiliar será instanciada como objeto...
	// Fazer uma anotação chamada @EmbeddedId. Funciona como um "id" embutido numa classe auxiliar...
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	// O "id" que foi criado vai servir como uma chave composta, semelhante aos tipos primitivos que já foram criados...
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	// Criar construtores...
	public ItemPedido() {
	}

	// Quando implementamos igual ao exemplo abaixo, por critérios de programação "ItemPedidoPK", não faz muito sentido...
	// public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
	// Deverá ser substituído por: Pedido pedido, Produto produto...
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		// No construtor, será atribuído pedido e produto dentro do objeto "id"...
		// Como estava anteriormente... this.id = id;
		// Será modificado por: id.setPedido(pedido) e id.setProduto(produto)...  
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	// Criar um "get" para Pedido e Produto...
	// Serve para ter acesso direto ao Pedido e Produto fora da classe ItemPedido, melhorando a semântica da classe...
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	// Criar Getters e Setters...
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	// Criar hashCode() e equals()...
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
