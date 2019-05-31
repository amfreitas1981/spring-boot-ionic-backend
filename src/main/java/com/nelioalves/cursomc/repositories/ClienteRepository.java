package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Cliente;

// Para a Camada de Acesso a Dados (Repository), relacionado a Camada de Domínio:
// Como fazer para que essa classe possa acessar o Banco de Dados?
// Criar classe (ClienteRepository) dentro do pacote repositories. É essa classe que será responsável para acessar as informações no Banco de Dados
// Colocar a anotação @Repository, importando de: org.springframework.stereotype.Repository
// Alterar de: "public class" para: "public interface"
// Os acessos são feitos, na verdade, de uma interface, herdando de outra interface, que seria JpaRepository, acessando objetos, neste caso, objetos Cliente e o tipo do atributo...
// Objetos Cliente, importados de: com.nelioalves.cursomc.resources.domain.Cliente
// A interface ClienteRepository poderá acessar o Banco de Dados, permitindo consultar, alterar...
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
