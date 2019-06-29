package br.unisul.farmax.dtos;

import java.io.Serializable;

import br.unisul.farmax.domain.Venda;

public class VendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer fk_id_cliente;
	private Integer fk_id_produto;
	private Integer qtd_produto;
	private Double valor;
	
	public VendaDTO() {

	}

	public VendaDTO(Venda obj) {
		id = obj.getId();
		fk_id_cliente = obj.getFk_id_cliente();
		fk_id_produto = obj.getFk_id_produto();
		qtd_produto = obj.getQtd_produto();
		valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFk_id_cliente() {
		return fk_id_cliente;
	}

	public void setFk_id_cliente(Integer fk_id_cliente) {
		this.fk_id_cliente = fk_id_cliente;
	}

	public Integer getFk_id_produto() {
		return fk_id_produto;
	}

	public void setFk_id_produto(Integer fk_id_produto) {
		this.fk_id_produto = fk_id_produto;
	}

	public Integer getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(Integer qtd_produto) {
		this.qtd_produto = qtd_produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
