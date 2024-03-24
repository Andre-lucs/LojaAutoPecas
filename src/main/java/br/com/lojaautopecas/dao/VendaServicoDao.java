package br.com.lojaautopecas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaautopecas.CriacaoTabelas.TabelaVendaServico;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Servico;
import br.com.lojaautopecas.model.Venda;
import br.com.lojaautopecas.model.VendaServico;

public class VendaServicoDao {
	
	private Connection conexao;

    public VendaServicoDao() {
        this.conexao = new DBConnection().getConexao();
	}
   

    // Método para verificar se a tabela Servico já existe no banco
    private boolean tabelaVendaServicoExiste() throws SQLException, SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "vendaservico", null);
        return tables.next();
    }

 // Método para criar uma relação Venda-Servico no banco
 public void inserirVendaServico(VendaServico vendaServico) throws SQLException {
     if (!tabelaVendaServicoExiste()) {
         TabelaVendaServico tabelaVendaServico = new TabelaVendaServico();
         tabelaVendaServico.criar();
     }
     // Buscar o preço do serviço pelo ID do serviço
     double precoServico = buscarPrecoServico(vendaServico.getId_Servico());

     int id_venda = vendaServico.getId_Venda();

     VendaDao vendaDao = new VendaDao();
     Venda venda = vendaDao.buscarVendaPorId(id_venda);

     vendaDao.somarValorTotalVendaServico(venda, precoServico);

     String sql = "INSERT INTO vendaservico (id_venda, id_servico) VALUES (?, ?)";
     try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
         stmt.setInt(1, vendaServico.getId_Venda());
         stmt.setInt(2, vendaServico.getId_Servico());
         stmt.executeUpdate();
         System.out.println("Relação Venda-Servico criada com sucesso!");
     } catch (SQLException e) {
         throw new RuntimeException("Erro ao criar a relação Venda-Servico: " + e.getMessage());
     }
 }

// Método para listar todos os serviços relacionados a uma venda específica
    public List<Servico> listarServicosPorIdVenda(int idVenda) {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT s.* FROM Servico s INNER JOIN VendaServico vs ON s.id = vs.id_Servico WHERE vs.id_Venda = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os serviços por ID de venda", e);
        }
        return servicos;
    }
    private double buscarPrecoServico(int idServico) throws SQLException {
        String sql = "SELECT preco FROM Servico WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idServico);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("preco");
            } else {
                throw new IllegalArgumentException("Serviço não encontrado com o ID fornecido: " + idServico);
            }
        }
    }

    // Método para deletar uma relação Venda-Servico do banco
    public void deletarVendaServico(int id_venda, int id_servico) throws SQLException {
        double precoServico = buscarPrecoServico(id_servico);

        VendaDao vendaDao = new VendaDao();
        Venda venda = vendaDao.buscarVendaPorId(id_venda);

        vendaDao.subtrairValorTotalVendaServico(venda, precoServico);

        String sql = "DELETE FROM vendaservico WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id_venda);
            stmt.executeUpdate();
            System.out.println("Relação Venda-Servico excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a relação Venda-Servico: " + e.getMessage());
        }
    }
}
