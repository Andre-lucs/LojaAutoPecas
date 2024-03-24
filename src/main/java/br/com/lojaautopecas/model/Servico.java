package br.com.lojaautopecas.model;

import java.util.Objects;

public class Servico {
    private int id;
    private String descricao;
    private Double preco;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Servico servico = (Servico) o;
		return id == servico.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
