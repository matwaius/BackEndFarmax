package br.unisul.farmax.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.farmax.repositories.ClienteRepository;
import br.unisul.farmax.repositories.ProdutoRepository;
import br.unisul.farmax.domain.Produto;
import br.unisul.farmax.domain.Cliente;

@Service
public class DbService {
	
	@Autowired
	private ClienteRepository clieRep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	public void inicializaBancoDeDados() throws ParseException {
	
		Cliente cli1 = new Cliente(null, "Glória a Deuxx", 20.0);
		clieRep.saveAll(Arrays.asList(cli1));
		
		Produto p1 = new Produto(null, "Produto 1", 10.00,100.00);
		Produto p2 = new Produto(null, "Produto 2", 20.00,200.00);
		Produto p3 = new Produto(null, "Produto 3", 30.00,300.00);
		
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
	}

}
