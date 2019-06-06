package br.unisul.farmax.dtos;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double saldo_devedor;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo_devedor() {
		return saldo_devedor;
	}
	public void setSaldo_devedor(Double saldo_devedor) {
		this.saldo_devedor = saldo_devedor;
	}
	
	
}
