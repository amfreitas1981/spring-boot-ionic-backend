package com.nelioalves.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

// Inserir anotação @RestController. No momento que inserimos, quando validamos (CTRL + Shift + O), vai aparecer o import org.springframework.web.bind.annotation.RestController.
@RestController
@RequestMapping(value = "/categorias") // O valor inserido, por padrão de mercado, é feito no plural
public class CategoriaResource {
// Toda classe que criamos, inicia com a letra 'maiúscula', para indicar o nome da classe de domínio, seguida do nome do pacote. Exemplo: CategoriaResource
	
	@Autowired
	private CategoriaService service; 
	
	// Criado o método, para conferir que está funcionando... "public String listar(){}"... Retornando: "REST está funcionando..."
	// Somente para obter um dado
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	// Mudar de "String" para "List<Categoria>"... public String listar() {
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		
		// Atualizar a classe "CategoriaResource.java" para atualizar o Controlador REST
		// Acrescentar o "id" nesta classe, adicionando 'value=/{id}', lembrando que o nome que está dentro das chaves, pode ser criado com o nome que quiser, na anotação @RequestMapping
		// Alterar o nome do método para "find", que vai receber um "id" da URL, incluindo a anotação @PathVariable, importada de: org.springframework.web.bind.annotation.PathVariable
		// Alterar o objeto "List<Categoria>" para "ResponseEntity<?>". É um tipo especial que encapsula todas as informações de uma resposta HTTP, alterando o tipo para "?", que poderá ser considerado qualquer tipo a encontrar... 
		// Fazer uma declaração "CategoriaService", seguida da anotação @Autowired para instanciar automaticamente...
		// Declarar "Categoria obj = service.buscar(id)", para retornar os objetos declarados para Categoria...
		// Para acessar o Serviço, que vai acessar o Repository, seguindo essa ordem...
		// O retorno será implementado assim:
			return ResponseEntity.ok().body(obj);
		// Apagar o trecho de código feito anteriormente... 
		// Para testar se funcionou, inicia o servidor
		// Quando testar, usando "localhost:8080/categorias/1" no Postman, não será retornado nada, porque o banco não foi atualizado... 
		// Conectar novamente o Banco H2 para inserir manualmente na guia do SQL...
		// Utilizar as queries (exemplos):
			// INSERT INTO CATEGORIA(NOME) VALUES ('Informática');
			// INSERT INTO CATEGORIA(NOME) VALUES ('Escritório');
		// Clicar na classe CATEGORIA e executar o select... 
			// SELECT * FROM CATEGORIA;
		// Vai aparecer todos os itens inseridos...
		// Agora, quando testar novamente no Postman, vai aparecer somente o primeiro item criado. Isso aconteceu, porque, como o Banco insere os dados baseado no ID, então o "/1", corresponde a posicao que o usuario cadastrou no BD. Se testar "localhost:8080/categorias/2", vai retornar o segundo item e assim por diante...
		// Agora, se testarmos: "localhost:8080/categorias/3", vai executar e retornar nada, porque o item 3 não foi inserido no banco, é considerado erro, mesmo retornando sucesso no HTTP (200), mas será feito um tratamento para evitar que isso aconteça, colocando tratamento de exceções...
		// Agora, se testarmos: "localhost:8080/categorias/", vai retornar erro 404 (Not Found)...
		// Fazer o commit das alterações...
		
		/* Anteriormente, quando mapeamemos um objeto para cada id...
		 * 
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
		*/
	} 
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
