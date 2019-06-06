package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		// A função "findOne()" serve para retornar o conteúdo que vem dentro do parênteses, quando declarado, atribuindo ao objeto. Se não tiver, retorna NULO... 
		if (obj == null) {
			// Se o objeto "obj" retornar nulo, a exceção é tratada aqui dentro... 
			// Na classe PedidoService.java, colocar o tratamento a ser feito, retornando do pacote que criou, colocando a mensagem de erro que for pertinente ao tratamento de erro... 
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
}