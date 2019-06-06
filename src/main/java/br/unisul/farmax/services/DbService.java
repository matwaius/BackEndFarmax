package br.unisul.farmax.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.farmax.repositories.ClienteRepository;
import br.unisul.farmax.domain.Cliente;

@Service
public class DbService {
	
	@Autowired
	private ClienteRepository clieRep;
	public void inicializaBancoDeDados() throws ParseException {
	
		Cliente cli1 = new Cliente(null, "Jesus Amém", 20.0);
		clieRep.saveAll(Arrays.asList(cli1));
	}

}
