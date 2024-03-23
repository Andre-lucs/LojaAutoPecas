package br.com.lojaautopecas.CriacaoTabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.lojaautopecas.jdbc.DBConnection;

public class TabelaVeiculo {
    private Connection conexao;

    public TabelaVeiculo() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException {
        String sql = "CREATE TABLE veiculo (" +
                "id SERIAL PRIMARY KEY," +
                "modelo VARCHAR(100) NOT NULL," +
                "marca VARCHAR(100) NOT NULL," +
                "ano INTEGER NOT NULL" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Veiculo criada com sucesso!");
        conexao.close();
    }
}
