package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Cidade;

// Para a Camada de Acesso a Dados (Repository), relacionado a Camada de Domínio:
// Como fazer para que essa classe possa acessar o Banco de Dados?
// Criar classe (CidadeRepository) dentro do pacote repositories. É essa classe que será responsável para acessar as informações no Banco de Dados
// Colocar a anotação @Repository, importando de: org.springframework.stereotype.Repository
// Alterar de: "public class" para: "public interface"
// Os acessos são feitos, na verdade, de uma interface, herdando de outra interface, que seria JpaRepository, acessando objetos, neste caso, objetos Cidade e o tipo do atributo...
// Objetos Cidade, importados de: com.nelioalves.cursomc.resources.domain.Cidade
// A interface CidadeRepository poderá acessar o Banco de Dados, permitindo consultar, alterar...
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
}
