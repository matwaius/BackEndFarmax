package br.unisul.farmax.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.farmax.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	List<Produto> findDistinctByNomeContainingOrderByNome(String nome);
}
