package br.com.lojaautopecas.CriacaoTabelas;

import br.com.lojaautopecas.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaPeca {
    private Connection conexao;

    public TabelaPeca() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException {
        // SQL para criar a tabela Cliente
        String sql = "CREATE TABLE peca (" +
                "id SERIAL PRIMARY KEY," +
                "nome VARCHAR(100) NOT NULL," +
                "preco DOUBLE PRECISION NOT NULL)";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Peça criada com sucesso!");
        conexao.close();
    }
}
