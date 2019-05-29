package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		// A função "findOne()" serve para retornar o conteúdo que vem dentro do parênteses, quando declarado, atribuindo ao objeto. Se não tiver, retorna NULO... 
		if (obj == null) {
			// Se o objeto "obj" retornar nulo, a exceção é tratada aqui dentro... 
			// Na classe CategoriaService.java, colocar o tratamento a ser feito, retornando do pacote que criou, colocando a mensagem de erro que for pertinente ao tratamento de erro... 
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
}