package br.com.lojaautopecas.model;

import java.util.Date;

public class Venda {
    private int id;
    private Date data;
    private Double valor_Total;
    private int id_Cliente;
    private int id_Funcionario;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValor_Total() {
		return valor_Total;
	}
	public void setValor_Total(Double valor_Total) {
		this.valor_Total = valor_Total;
	}
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public int getId_Funcionario() {
		return id_Funcionario;
	}
	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}
    }
