package br.unisul.farmax.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer fk_id_cliente;
	
	private Integer fk_id_produto;
	
	private Integer qtd_produto;
	
	private Double valor;
	
	public Venda() {
			
		}
	
	public Venda(Integer id, Integer fk_id_cliente, Integer fk_id_produto, Integer qtd_produto, Double valor) {
		super();
		this.id = id;
		this.fk_id_cliente = fk_id_cliente;
		this.fk_id_produto = fk_id_produto;
		this.qtd_produto = qtd_produto;
		this.valor = valor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
