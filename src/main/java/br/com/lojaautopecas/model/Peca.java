package br.com.lojaautopecas.model;

import java.util.Objects;

public class Peca {
    private int id;
    private String nome;
    private Double preco;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Peca peca = (Peca) o;
		return id == peca.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
