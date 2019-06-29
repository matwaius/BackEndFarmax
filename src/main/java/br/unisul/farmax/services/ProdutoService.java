package br.unisul.farmax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.farmax.repositories.ProdutoRepository;
import br.unisul.farmax.domain.Produto;
import br.unisul.farmax.dtos.ProdutoNewDTO;
import br.unisul.farmax.dtos.ProdutoDTO;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//BUSCAR POR NOME
	public List<Produto> buscaPorNome(String nome)
	{
		return repo.findDistinctByNomeContainingOrderByNome(nome);
	}
	
	//INSERIR
	public Produto insert(Produto obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	//ATUALIZAR
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	//DELETE
	public void delete (Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getEstoque(), objDto.getValor());
	}
	
	public Produto fromDTO(ProdutoNewDTO objDto) {
		Produto pro = new Produto(null, objDto.getNome(), objDto.getEstoque(), objDto.getValor());
		return pro;
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setNome(obj.getNome());
		newObj.setEstoque(obj.getEstoque());
		newObj.setValor(obj.getValor());
	}
}
