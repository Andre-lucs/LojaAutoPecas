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
        String sql = "INSERT INTO vendaServico (id_venda, id_servico) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, vendaServico.getId_Venda());
            stmt.setInt(2, vendaServico.getId_Servico());
            stmt.executeUpdate();
            System.out.println("Relação Venda-Servico criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a relação Venda-Servico: " + e.getMessage());
        }
    }

    // Método para listar todas as relações Venda-Servico do banco
    public List<VendaServico> listarVendaServico() {
        List<VendaServico> listaVendaServico = new ArrayList<>();
        String sql = "SELECT * FROM Venda_Servico";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                VendaServico vendaServico = new VendaServico();
                vendaServico.setId(rs.getInt("id"));
                vendaServico.setId_Venda(rs.getInt("id_venda"));
                vendaServico.setId_Servico(rs.getInt("id_servico"));

                listaVendaServico.add(vendaServico);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar as relações Venda-Servico: " + e.getMessage());
        }

        return listaVendaServico;
    }

    // Método para atualizar uma relação Venda-Servico no banco
    public void atualizarVendaServico(int id, VendaServico novosDadosVendaServico) {
        String sql = "UPDATE vendaServico SET id_venda=?, id_servico=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, novosDadosVendaServico.getId_Venda());
            stmt.setInt(2, novosDadosVendaServico.getId_Servico());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Relação Venda-Servico atualizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a relação Venda-Servico: " + e.getMessage());
        }
    }

    // Método para deletar uma relação Venda-Servico do banco
    public void deletarVendaServico(int id) {
        String sql = "DELETE FROM vendaServico WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Relação Venda-Servico excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a relação Venda-Servico: " + e.getMessage());
        }
    }
}
