package br.com.lojaautopecas.CriacaoTabelas;

import br.com.lojaautopecas.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaVenda {
    private Connection conexao;

    public TabelaVenda() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException, SQLException {
        String sql = "CREATE TABLE venda (" +
                "id SERIAL PRIMARY KEY," +
                "data DATE NOT NULL," +
                "valor_Total DOUBLE PRECISION NOT NULL," +
                "id_Cliente INTEGER NOT NULL," +
                "id_Funcionario INTEGER NOT NULL," +
                "FOREIGN KEY (id_Cliente) REFERENCES Cliente(id) ON DELETE CASCADE," +
                "FOREIGN KEY (id_Funcionario) REFERENCES Funcionario(id) ON DELETE CASCADE" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Venda criada com sucesso!");
        conexao.close();
    }
}
