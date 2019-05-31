package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nelioalves.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable{

	// Criada a versão padrão da Serializable: "1L"... São exigências do Java...
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// Implementar atributos...
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	// Incluir atributo TipoCliente, importado do pacote enums...
	// private TipoCliente tipo;
	// Alterar de TipoCliente para Integer para armazenar internamente...
	private Integer tipo;
	
	// Fazer a relação um para muitos... Um cliente pode ter vários endereços...
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	// Fazer a relação muitos para um... Vários endereços pode ter um cliente...
	private Cliente cliente;
	
	// Por ser muitas strings, dessa vez, será tratado como uma lista, mas não com repetições quando declaramos com tipo "Set", porque é um conjunto...
	// Set: importado de java.util.Set...
	// A classe que pode ser atribuída para "Set", utilizamos o "HashSet"...
	// Para que o JPA possa mapear normalmente e executar no banco corretamente, utilizaremos as anotações:
	// @ElementCollection, importando de javax.persistence...
	// @CollectionTable - Tabela de dados adicional no banco para guardar as informações, importando de javax.persistence...
	@ElementCollection
	@CollectionTable(name="TELEFONE") // Nome da tabela que será criada no banco...
	private Set<String> telefones = new HashSet<>();
	
	// Criar os construtores...
	public Cliente() {
	}

	// Para gerar o construtor com argumentos, lembrando que devemos declarar todos os campos, exceto os de COLEÇÃO...
	// Repare que TipoCliente será mantido, ao contrário do atributo, somente para ser exposto...
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		// Depois que o tipo foi modificado para Integer, na declaração do atributo, vai apresentar erro...
		// this.tipo = tipo;
		// Alterar para: tipo.getCod(); que o erro será resolvido...
		this.tipo = tipo.getCod();
	}

	// Criar os getters e setters...
	// Também será preciso alterar tudo que foi declarado onde estiver TipoCliente...
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		// Alterar, ajustando para: "TipoCliente.toEnum(tipo)"... Porque são consideradas as configurações do enum TipoCliente...
		// Como estava antes do ajuste: return tipo;
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		// Alterar, incluindo ".getCod()"...
		// Como estava anteriormente: this.tipo = tipo;
		this.tipo = tipo.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	// Incluir hashCode() e equals(). Lembrando que marcamos SOMENTE o "id"...
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
