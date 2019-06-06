package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// Ao declarar o atributo do tipo Date, devemos importar de "java.util.Date"... SEMPRE!!!
	private Date instante;
	
	// Criar um atributo de associação entre Pedido e Pagamento...
	// Utilizar anotação @OneToOne(cascade=CascadeType.ALL, mappedBy="pedido"), que garante o mapeamento e evita erros...
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido") 
	private Pagamento pagamento;
	
	// Criar um atributo de associação entre Pedido e Cliente...
	// Inserir anotações @ManyToOne e @JoinColumn, para manter a relação, como está no papel (muitos para um)...
	// @JoinColumn: responsável por criar a chave estrangeira para as duas tabelas...
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	// Criar um atributo de associação entre Pedido e Endereco, criando o campo enderecoDeEntrega, como está no papel...
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	// Será feito um conjunto de itens, como segue no papel (diagrama). Itens não faz parte do produto, mas pode ser considerado...
	// Declarado nas classes Pedido e Produto... Serve para reconhecer os itens associados...
	// Como já foi feita a anotação @ManyToOne nas classes Pedido e Produto, agora será feita ao contrário, declarando: @OneToMany
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {
	}

	// Remover a instância referente a Pagamento pagamento, apagando do construtor. Na classe principal vai receber todos os dados, menos "pagamento"...
	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	// Criação de getters e setters...
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	// Criar hashCode() e equals(), marcando somente o "id"...
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
