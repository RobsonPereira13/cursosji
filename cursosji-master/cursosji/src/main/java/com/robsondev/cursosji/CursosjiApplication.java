package com.robsondev.cursosji;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.robsondev.cursosji.domain.Categoria;
import com.robsondev.cursosji.domain.Cidade;
import com.robsondev.cursosji.domain.Cliente;
import com.robsondev.cursosji.domain.Endereco;
import com.robsondev.cursosji.domain.Estado;
import com.robsondev.cursosji.domain.Produto;
import com.robsondev.cursosji.domain.enums.TipoCliente;
import com.robsondev.cursosji.repositories.CategoriaRepository;
import com.robsondev.cursosji.repositories.CidadeRepository;
import com.robsondev.cursosji.repositories.ClienteRepository;
import com.robsondev.cursosji.repositories.EnderecoRepository;
import com.robsondev.cursosji.repositories.EstadoRepository;
import com.robsondev.cursosji.repositories.ProdutoRepository;

@SpringBootApplication
public class CursosjiApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository repo1;
	@Autowired
	private EstadoRepository repo2;
	@Autowired
	private CidadeRepository repo3;
	@Autowired
	private ClienteRepository repo4;
	@Autowired
	private EnderecoRepository repo5;
	
	public static void main(String[] args) {
		SpringApplication.run(CursosjiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		Estado estado1 = new Estado (null,"Pernambuco");
		Estado estado2 = new Estado (null,"Paraíba");
		
		Cidade c1 = new Cidade (null,"Recife",estado1);
		Cidade c2 = new Cidade (null,"Jaboatão",estado1);
		Cidade c3 = new Cidade (null,"João Pessoa",estado2);
		
		Cliente cli1 = new Cliente(null,"Robson","robson@gmail.com","09876524322",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("081988313154","081996983206"));
		Cliente cli2 = new Cliente(null,"Robson","robson@gmail.com","09876524322",TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("081988313154","081996983206"));
		
		Endereco end1 = new Endereco(null,"Dr Valdir Pessoa","100","quadra a","Imbiribeira","511500790",cli1,c1);
		Endereco end2 = new Endereco(null,"Dr Valdir Pessoa","100","quadra a","Imbiribeira","511500790",cli1,c2);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		estado1.getCidades().addAll(Arrays.asList(c1,c2));
		estado2.getCidades().addAll(Arrays.asList(c3));
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		repo1.saveAll(Arrays.asList(p1,p2,p3));
		repo2.saveAll(Arrays.asList(estado1,estado2));
		repo3.saveAll(Arrays.asList(c1,c2,c3));
		repo4.saveAll(Arrays.asList(cli1,cli2));
		repo5.saveAll(Arrays.asList(end1,end2));
		
	}

}
