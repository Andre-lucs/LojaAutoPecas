package br.com.lojaautopecas.CriacaoTabelas;
import br.com.lojaautopecas.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TabelaVendaServico {
	private Connection conexao;

    public TabelaVendaServico() {
        this.conexao = new DBConnection().getConexao();
    }

    public void criar() throws SQLException, SQLException {
        String sql = "CREATE TABLE vendaServico (" +
                "id SERIAL PRIMARY KEY," +
                "id_Venda INTEGER NOT NULL," +
                "id_Servico INTEGER NOT NULL," +
                "FOREIGN KEY (id_Venda) REFERENCES Venda(id) ON DELETE CASCADE," +
                "FOREIGN KEY (id_Servico) REFERENCES Servico(id) ON DELETE CASCADE" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela VendaServico criada com sucesso!");
        conexao.close();
    }
}
