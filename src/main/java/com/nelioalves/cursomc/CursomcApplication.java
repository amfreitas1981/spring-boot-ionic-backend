package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Instanciar as categorias no BD...
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// Instanciar os produtos no BD...
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		// Para associar os produtos retornados no BD, utilizando seus relacionamentos (somente o que está relacionado no diagrama)...
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// Associar as categorias, conforme as relações obtidas para cada produto...
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// Criar uma repository para Categoria
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		// Criar uma repository para Produto
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		// Instanciar os estados no BD...
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		// Instanciar as cidades no BD...
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);		
		
		// Para associar os estados retornados no BD, utilizando seus relacionamentos (somente o que está relacionado no diagrama)...
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		// Criar uma repository para Estado
		estadoRepository.save(Arrays.asList(est1, est2));
		// Criar uma repository para Cidades
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		// Instanciar os clientes no BD...
		// O "tipo" será instanciado numericamente, no caso de "TipoCliente". Ao fazer a instância, vai aparecer as opções que deverão ser aplicadas...
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36376912377", TipoCliente.PESSOAFISICA);
		
		// Para adicionar os telefones do Cliente aplicados na instância...
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		// Instanciar os endereços no BD...
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		// Para atribuir os endereços atrelados ao Cliente...
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// Criar uma repository para Cliente
		clienteRepository.save(Arrays.asList(cli1));
		
		// Criar uma repository para Endereco
		enderecoRepository.save(Arrays.asList(e1, e2));
		
		// Para mapear o conteúdo no formato de "data", será criado um objeto auxiliar...
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		// Instanciar os pedidos no BD...
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e2);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		// Instanciar os pagamentos no BD...
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		// Associar os pedidos com clientes...
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		// Como salvar os objetos no BD...
		// Criando uma classe no pacote repositories. Exemplo (neste caso): PedidoRepository e PagamentoRepository...
		// Criar uma repository para Categoria
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		// Criar uma repository para Produto
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
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
