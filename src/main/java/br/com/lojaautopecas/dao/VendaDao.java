package br.com.lojaautopecas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lojaautopecas.CriacaoTabelas.TabelaVenda;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Venda;

public class VendaDao {
	  private Connection conexao;

	    public VendaDao() {
	        this.conexao = new DBConnection().getConexao();
	    }

	    // Método para verificar se a tabela Venda já existe no banco
	    private boolean tabelaVendaExiste() throws SQLException, SQLException {
	        DatabaseMetaData metaData = conexao.getMetaData();
	        ResultSet tables = metaData.getTables(null, null, "venda", null);
	        return tables.next();
	    }

	    // Método para inserir uma venda no banco
	    public void inserirVenda(Venda venda) throws SQLException {
	        if (!tabelaVendaExiste()) {
	            TabelaVenda tabelaVenda = new TabelaVenda();
	            tabelaVenda.criar();
	        }

	        String sql = "INSERT INTO venda (data, valor_Total, id_Cliente, id_Funcionario) " +
	                "VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setDate(1, new java.sql.Date (venda.getData().getTime()));
	            stmt.setDouble(2, venda.getValor_Total());
	            stmt.setInt(3, venda.getId_Cliente());
	            stmt.setInt(4, venda.getId_Funcionario());
	            stmt.executeUpdate();
	            System.out.println("Venda criada com sucesso!");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }


	    // Método para listar todas as vendas do banco
	    public List<Venda> listarVendas() {
	        try {
	            List<Venda> vendas = new ArrayList<>();
	            String sql = "SELECT * FROM venda ORDER BY id";

	            try (PreparedStatement stmt = conexao.prepareStatement(sql);
	                 ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    Venda venda = new Venda();
	                    venda.setId(rs.getInt("id"));
	                    venda.setData(rs.getDate("data"));
	                    venda.setValor_Total(rs.getDouble("valor_Total"));
	                    venda.setId_Cliente(rs.getInt("id_Cliente"));
	                    venda.setId_Funcionario(rs.getInt("id_Funcionario"));

	                    vendas.add(venda);
	                }
	                rs.close();
	                stmt.close();
	            }
	            return vendas;
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    
	 // Método para atualizar uma venda no banco
	    public void atualizarVenda(Integer id, Venda novosDadosVenda) {
	        String sql = "UPDATE venda SET data=?, valor_Total=?, id_Cliente=?, id_Funcionario=? WHERE id=?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setDate(1, new java.sql.Date(novosDadosVenda.getData().getTime()));
	            stmt.setDouble(2, novosDadosVenda.getValor_Total());
	            stmt.setInt(3, novosDadosVenda.getId_Cliente());
	            stmt.setInt(4, novosDadosVenda.getId_Funcionario());
	            stmt.setInt(5, id); // Define o ID da venda a ser atualizada
	            stmt.executeUpdate();
	            System.out.println("Venda atualizada com sucesso!");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	 // Método para deletar uma venda do banco
	    public void deletarVenda(Integer id) {
	        String sql = "DELETE FROM venda WHERE id=?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	            System.out.println("Venda excluída com sucesso!");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
