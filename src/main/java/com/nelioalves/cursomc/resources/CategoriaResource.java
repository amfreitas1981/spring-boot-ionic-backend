package com.nelioalves.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Inserir anotação @RestController. No momento que inserimos, quando validamos (CTRL + Shift + O), vai aparecer o import org.springframework.web.bind.annotation.RestController.
@RestController
@RequestMapping(value = "/categorias") // O valor inserido, por padrão de mercado, é feito no plural
public class CategoriaResource {
// Toda classe que criamos, inicia com a letra 'maiúscula', para indicar o nome da classe de domínio, seguida do nome do pacote. Exemplo: CategoriaResource
	
	// Criado o método, para conferir que está funcionando... "public String listar(){}"... Retornando: "REST está funcionando..."
	@RequestMapping(method=RequestMethod.GET) // Somente para obter um dado
	public String listar() {
		return "REST está funcionando!";
	} 
	
	

}
