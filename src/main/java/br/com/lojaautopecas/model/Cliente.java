package br.com.lojaautopecas.model;


public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private int id_Veiculo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId_Veiculo() {
		return id_Veiculo;
	}
	public void setId_Veiculo(int id_Veiculo) {
		this.id_Veiculo = id_Veiculo;
	}
	
   
}
