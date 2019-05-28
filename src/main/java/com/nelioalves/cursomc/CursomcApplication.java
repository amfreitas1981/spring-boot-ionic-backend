package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		
	}
	
	// Aula 15...
	// Como executar a instanciação quando iniciar (ou reiniciar) o servidor:
	// As configurações são feitas acessando a classe principal "CursomcApplication"...
	// Implementar a interface CommandLineRunner, importando de: org.springframework.boot.CommandLineRunner. Ele permite executar um método auxiliar quando subir a aplicação... 
	// Clicar no erro, em Add uninplemented methods. Será feito automaticamente, incluindo a assinatura... 
	// Criar referência "CategoriaRepository" (tipo private): private CategoriaRepository categoriaRepository, seguida da anotação @Autowired ...
	// Inserir objetos "cat1" e "cat2"... 
	// Os objetos são instanciados dessa forma: Categoria cat1 = new Categoria(null, "Informática");
	// Repare que inserimos como "null", porque o 'id' será definido pelo Banco de Dados...
	// Para retornar as listas, utilizamos o objeto ".save" ou ".saveAll" (Para versão 2.x.x do Spring). Ele serve para retornar a lista de objetos que o banco vai devolver quando subimos... 
	// Exemplo: categoriaRepository.save(Arrays.asList(cat1, cat2));
	// Onde retornamos o conteúdo do método acessado no formato de lista (Arrays, que importamos de: java.util.Arrays)... 
	// Rodar a aplicação para verificar se está funcionando no Postman... Com essas alterações, os erros vistos anteriormente ainda não foram tratados...
	// Fazer o commit das alterações...
	
}
