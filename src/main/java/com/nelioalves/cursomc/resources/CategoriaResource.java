package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.resources.domain.Categoria;

// Inserir anotação @RestController. No momento que inserimos, quando validamos (CTRL + Shift + O), vai aparecer o import org.springframework.web.bind.annotation.RestController.
@RestController
@RequestMapping(value = "/categorias") // O valor inserido, por padrão de mercado, é feito no plural
public class CategoriaResource {
// Toda classe que criamos, inicia com a letra 'maiúscula', para indicar o nome da classe de domínio, seguida do nome do pacote. Exemplo: CategoriaResource
	
	// Criado o método, para conferir que está funcionando... "public String listar(){}"... Retornando: "REST está funcionando..."
	// Somente para obter um dado
	@RequestMapping(method=RequestMethod.GET)
	// Mudar de "String" para "List<Categoria>"... public String listar() {
	public List<Categoria> listar() {
		
		// Criar dois objetos do tipo Categoria, conforme a relação, que consta no diagrama, em CategoriaResource.java... Quando digitamos (CTRL + Shift + O), vai aparecer o import da classe domain... 
		Categoria cat1 = new Categoria(1, "Informática"); 
		Categoria cat2 = new Categoria(2, "Escritório");
		
		// Criar uma lista de categorias. O comando 'List' deverá ser importado de: java.util.List...
		// O List é uma interface, não pode ser instanciado. Deverá "achar" uma classe que implementa essa interface para instanciar uma lista e importar "java.util.ArrayList"... 
		List<Categoria> lista = new ArrayList<>();
		
		// Adicionar os campos na lista... lista.add(cat1)... Adicionando duas categorias...
		lista.add(cat1);
		lista.add(cat2);
		
		// Agora a classe vai retornar lista...
		return lista;
	} 
	
	

}
