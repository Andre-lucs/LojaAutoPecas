package br.com.lojaautopecas.CriacaoTabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.lojaautopecas.jdbc.DBConnection;

public class TabelaFuncionario {
	private Connection conexao;

    public TabelaFuncionario() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException {
    	String sql = "CREATE TABLE funcionario (" +
                "id SERIAL PRIMARY KEY," +
                "cpf VARCHAR(14) NOT NULL UNIQUE," +
                "nome VARCHAR(100) NOT NULL," +
                "cargo VARCHAR(25)," +
                "senha VARCHAR(15) NOT NULL" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Funcionario criada com sucesso!");
        conexao.close();
    }
}