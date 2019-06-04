package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	// Por ser uma subclasse, devemos criar o construtor vazio... 
	// Por ser uma subclasse, devemos criar o construtor como: Generate Constructors from Superclass... 
	// Detalhe: Se não instanciarmos a classe com 'extends', não vai funcionar!!!
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		// Acrescentar atribuições...
		// Será recebido como argumento...
		this.numeroDeParcelas = numeroDeParcelas;
	}

	// Criar atributo get e set, somente o atributo que falta, porque o restante pega da superclasse...
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
