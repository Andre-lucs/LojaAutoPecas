package br.com.lojaautopecas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaautopecas.CriacaoTabelas.TabelaVendaPeca;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.VendaPeca;

public class VendaPecaDao {

    private Connection conexao;

    public VendaPecaDao() {
        this.conexao = new DBConnection().getConexao();
    }

    // Método para verificar se a tabela Peça já existe no banco
    private boolean tabelaVendaPecaExiste() throws SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "vendapeca", null);
        return tables.next();
    }

    // Método para criar uma relação Venda-Peça no banco
    public void inserirVendaPeca(VendaPeca vendaPeca) throws SQLException {
        if (!tabelaVendaPecaExiste()) {
            TabelaVendaPeca tabelaVendaPeca = new TabelaVendaPeca();
            tabelaVendaPeca.criar();
        }
        String sql = "INSERT INTO vendapeca (id_venda, id_peca) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, vendaPeca.getId_Venda());
            stmt.setInt(2, vendaPeca.getId_Peca());
            stmt.executeUpdate();
            System.out.println("Relação Venda-Peça criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a relação Venda-Peça: " + e.getMessage());
        }
    }

 // Método para listar todos os registros de VendaPeca relacionados a uma venda específica
    public List<VendaPeca> listarVendaPecasPorIdVenda(int idVenda) {
        List<VendaPeca> vendaPecas = new ArrayList<>();
        String sql = "SELECT * FROM VendaPeca WHERE id_Venda = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VendaPeca vendaPeca = new VendaPeca();
                vendaPeca.setId(rs.getInt("id"));
                vendaPeca.setId_Venda(rs.getInt("id_Venda"));
                vendaPeca.setId_Peca(rs.getInt("id_Peca"));
                vendaPecas.add(vendaPeca);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os registros de VendaPeca por ID de venda", e);
        }
        return vendaPecas;
    }

    // Método para atualizar uma relação Venda-Peça do banco
    public void atualizarVendaPeca(VendaPeca vendaPeca) {
        String sql = "UPDATE vendapeca SET id_venda = ?, id_peca = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, vendaPeca.getId_Venda());
            stmt.setInt(2, vendaPeca.getId_Peca());
            stmt.setInt(3, vendaPeca.getId());
            stmt.executeUpdate();
            System.out.println("Relação Venda-Peça atualizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a relação Venda-Peça: " + e.getMessage());
        }
    }

    // Método para deletar uma relação Venda-Peça do banco
    public void deletarVendaPeca(int id) {
        String sql = "DELETE FROM vendapeca WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Relação Venda-Peça deletada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a relação Venda-Peça: " + e.getMessage());
        }
    }
	
}
