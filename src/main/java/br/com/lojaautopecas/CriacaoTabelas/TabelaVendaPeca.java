package br.com.lojaautopecas.CriacaoTabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.lojaautopecas.jdbc.DBConnection;

public class TabelaVendaPeca {
    private Connection conexao;

    public TabelaVendaPeca() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException {
        String sql = "CREATE TABLE vendaPeca (" +
                "id SERIAL PRIMARY KEY," +
                "id_Venda INTEGER NOT NULL," +
                "id_Peca INTEGER NOT NULL," +
                "FOREIGN KEY (id_Venda) REFERENCES Venda(id) ON DELETE CASCADE," +
                "FOREIGN KEY (id_Peca) REFERENCES Peca(id) ON DELETE CASCADE" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela VendaPeca criada com sucesso!");
        conexao.close();
    }
}
