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
        String sql = "CREATE TABLE Venda (" +
                "id SERIAL PRIMARY KEY," +
                "data DATE NOT NULL," +
                "valor_Total DOUBLE NOT NULL," +
                "id_Cliente INTEGER," +
                "id_Funcionario INTEGER," +
                "id_Veiculo INTEGER," +
                "FOREIGN KEY (id_Cliente) REFERENCES Cliente(id)," +
                "FOREIGN KEY (id_Funcionario) REFERENCES Funcionario(id)," +
                "FOREIGN KEY (id_Veiculo) REFERENCES Veiculo(id)" +
                ")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela Venda criada com sucesso!");
        conexao.close();
    }

}
