package com.nelioalves.cursomc.domain.enums;

public enum TipoCliente {

	// Serve para declarar valores separados por "," e finalizando com ";'...
	// O valor numérico vai da sua preferência para organização...
	// Enviar código, retornando do TipoCliente, já organizado...
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica"); 

	// Existem duas formas que serão retornadas, quando declaramos somente com o nome. Ou por string, como será enviado ou por um número inteiro, que, por padrão, começa com "zero"...
	// O recomendado é colocar um valor para cada item, por medidas de segurança. Dessa forma, podemos fixar os valores para cada campo...
	// A numeração é definida dentro do parênteses, incluindo um alias à sua escolha... 
	// Construir construtores para atribuir valor enumerado...
	// Construtor enumerada é do tipo private
	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if(cod == null) {
			return null;
		}

		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		// E se "esgotar" o 'for' e não for ninguém...
		// Tratar exceção...
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
}