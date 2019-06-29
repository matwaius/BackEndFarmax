package br.unisul.farmax.dtos;

import java.io.Serializable;

public class ProdutoNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Double estoque;
	private Double valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getEstoque() {
		return estoque;
	}
	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
