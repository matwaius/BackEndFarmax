package br.unisul.farmax.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.farmax.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	List<Cliente> findDistinctByNomeContainingOrderByNome(String nome);
}
