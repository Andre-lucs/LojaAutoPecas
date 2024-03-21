package br.com.lojaautopecas.model;

import java.util.Date;

public class Venda {
    private Integer id;
    private Date data;
    private Double valor_Total;
    private Integer id_Cliente;
    private Integer id_Funcionario;
    private Integer id_Veiculo;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public Integer getId_Cliente() {
        return id_Cliente;
    }
    public void setId_Cliente(Integer id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    public Integer getId_Funcionario() {
        return id_Funcionario;
    }
    public void setId_Funcionario(Integer id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }
    public Integer getId_Veiculo() {
        return id_Veiculo;
    }
    public void setId_Veiculo(Integer id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }
}
