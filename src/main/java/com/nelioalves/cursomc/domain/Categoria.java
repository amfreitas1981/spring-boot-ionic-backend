package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// Inserir anotação @Entity na classe Categoria, que será uma entidade do JPA, importando de: javax.persistence.Entity, considerando a interface, não a implementação. SEMPRE!!!
@Entity
// A classe Categoria é declarada com a implementação "Serializable", conforme o exemplo: ... Categoria implements Serializable... Significa que a sequência gerada na classe será convertida em bytes...
public class Categoria implements Serializable{

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	// Para definir as estratégias de gerenciamento de IDs, deverá inserir as anotações abaixo, importando de javax.persistence, configurando dessa forma:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// Configurando o GenerationType como "IDENTITY", ele está preparado para trabalhar com H2. Senão, deverá selecionar outras opções, dependendo do BD que vai trabalhar...
	private Integer id;
	private String nome;
	
	 
	// Implementar a representação, respeitando o nome que consta no papel, tratados neste caso, como uma lista... 
	@ManyToMany(mappedBy = "categorias") 
	// A anotação acima serve para "fechar" o relacionamento entre as tabelas "Categoria" e "Produto"...
	private List<Produto> produtos = new ArrayList<>();
	
		
	// Para inserir todas as configurações do BD que será utilizado no arquivo application.properties, para gerar a Base de Dados...

	// Fazer os Construtores (não incluir coleções no instrutor com parâmetros). Lembrando que o construtor deve ser declarado vazio. Exemplo: linha abaixo...
	// Instancia o projeto sem jogar nada para os atributos
	public Categoria() {
	}

	// Gerar construtor para os atributos. Source > Generate Constructor using Fields... Incluir TODOS os campos, INCLUINDO o id...
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// Criar os getters e setters. Servem para dar acesso aos atributos do tipo private... Source > Generate Getters and Setters... Incluir TODOS os campos, INCLUINDO o id...
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

	// Criar getters e setters para "produtos", para onde faremos as relações...
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	// Fazer o hashCode() e equals() (padrão: somente o "id"); // Operação para comparar objetos por valor... Source > Generate hashCode() and equals()... Incluir TODOS os campos, SOMENTE o id...
	// Vai criar automaticamente a anotação @Override, (padrão para Java)
	// hashCode(): valor numérico para cada objeto... equals(): comparação entre dois objetos, considerando todas as possibilidades... 
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
