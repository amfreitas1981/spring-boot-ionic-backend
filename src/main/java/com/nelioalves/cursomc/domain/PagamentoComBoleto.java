package com.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	// A anotação @JsonFormat serve para configurar a formatação de data/hora para o atributo desejado...
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	// Por ser uma subclasse, devemos criar o construtor vazio... 
	// Por ser uma subclasse, devemos criar o construtor como: Generate Constructors from Superclass... 
	// Detalhe: Se não instanciarmos a classe com 'extends', não vai funcionar!!!
	public PagamentoComBoleto() {
	}

	// Depois que criar, adicionar manualmente os atributos 'dataVencimento' e 'dataPagamento', como seguem abaixo...
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// Acrescentar atribuições...
		// Serão recebidos como argumentos...
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	// Criar atributos getters e setters, somente os atributos que faltam, porque o restante pega da superclasse...
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
