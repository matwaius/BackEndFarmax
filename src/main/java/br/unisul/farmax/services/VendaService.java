package br.unisul.farmax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.farmax.domain.Cliente;
import br.unisul.farmax.domain.Venda;
import br.unisul.farmax.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	
	//INSERIR
	public Venda insert(Venda obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	//ATUALIZAR
	public Venda update (Venda obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	//DELETE
	public void delete (Integer id) {
		find(id);
		repo.deleteById(id);
	}

}
