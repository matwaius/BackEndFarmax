package br.unisul.farmax.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.farmax.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
