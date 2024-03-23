package br.com.lojaautopecas.CriacaoTabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.lojaautopecas.jdbc.DBConnection;

public class TabelaCliente {
    private Connection conexao;

    public TabelaCliente() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException {
        String sql = "CREATE TABLE Cliente (" +
                "id SERIAL PRIMARY KEY," +
                "cpf VARCHAR(14) NOT NULL UNIQUE," +
                "nome VARCHAR(100) NOT NULL," +
                "id_Veiculo INTEGER" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Cliente criada com sucesso!");
        conexao.close();
    }
}
