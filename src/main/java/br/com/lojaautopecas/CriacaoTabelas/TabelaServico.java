package br.com.lojaautopecas.CriacaoTabelas;

import br.com.lojaautopecas.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaServico {
    private Connection conexao;

    public TabelaServico() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException, SQLException {
        String sql = "CREATE TABLE Servico (" +
                "id SERIAL PRIMARY KEY," +
                "descricao VARCHAR(255) NOT NULL," +
                "preco DOUBLE NOT NULL" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Servico criada com sucesso!");
        conexao.close();
    }

}
