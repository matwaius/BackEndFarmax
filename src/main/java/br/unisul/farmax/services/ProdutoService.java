package br.unisul.farmax.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.farmax.repositories.ProdutoRepository;
import br.unisul.farmax.domain.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Produto insert(Produto obj) {
		obj = repo.save(obj);
		return obj;
	}
}
