package br.com.lojaautopecas.dao;

import br.com.lojaautopecas.CriacaoTabelas.TabelaVeiculo;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {
    private Connection conexao;

    public VeiculoDao() throws SQLException {
        this.conexao = new DBConnection().getConexao();
    }

    private boolean tabelaVeiculoExiste() throws SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "veiculo", null);
        return tables.next();
    }

    public void inserirVeiculo(Veiculo veiculo) throws SQLException {

        if (!tabelaVeiculoExiste()) {
            TabelaVeiculo tabelaVeiculo = new TabelaVeiculo();
            tabelaVeiculo.criar();
        }

        String sql = "INSERT INTO veiculo ( modelo, marca, ano) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getAno());
            stmt.execute();
            stmt.close();

            System.out.println("Veiculo criado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Veiculo> listarVeiculos() {
        try {
            List<Veiculo> veiculos = new ArrayList<>();
            String sql = "SELECT * FROM veiculo ORDER BY id";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setAno(rs.getInt("ano"));
                veiculos.add(veiculo);
                System.out.println(veiculo.getModelo());
            }
            rs.close();
            stmt.close();
            return veiculos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarVeiculo(int id, Veiculo novosDadosVeiculo) {
        String sql = "UPDATE veiculo SET modelo=?, marca=?, ano=? WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, novosDadosVeiculo.getModelo());
            stmt.setString(2, novosDadosVeiculo.getMarca());
            stmt.setInt(3, novosDadosVeiculo.getAno());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Veículo atualizado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deletarVeiculo(int id) {
        String sql = "DELETE FROM veiculo WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Veiculo excluído com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}