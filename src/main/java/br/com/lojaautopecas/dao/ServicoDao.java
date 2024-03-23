package br.com.lojaautopecas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaautopecas.CriacaoTabelas.TabelaServico;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Servico;

public class ServicoDao {

		private Connection conexao;

	    public ServicoDao() {
	        this.conexao = new DBConnection().getConexao();
		}
	   

	    // Método para verificar se a tabela Servico já existe no banco
	    private boolean tabelaServicoExiste() throws SQLException, SQLException {
	        DatabaseMetaData metaData = conexao.getMetaData();
	        ResultSet tables = metaData.getTables(null, null, "servico", null);
	        return tables.next();
	    }
	    
	 // Método para inserir um serviço no banco
	    public void inserirServico(Servico servico) throws SQLException {
	        if (!tabelaServicoExiste()) {
	            TabelaServico tabelaServico = new TabelaServico();
	            tabelaServico.criar();
	        }

	        String sql = "INSERT INTO servico (descricao, preco) VALUES (?, ?)";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setString(1, servico.getDescricao());
	            stmt.setDouble(2, servico.getPreco());
	            stmt.executeUpdate();
	            System.out.println("Serviço inserido com sucesso!");
	        } catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }
	    
	 // Método para listar todos os serviços do banco
	    public List<Servico> listarServicos() {
	        try {
	            List<Servico> servicos = new ArrayList<>();
	            String sql = "SELECT * FROM servico ORDER BY id";

	            try (PreparedStatement stmt = conexao.prepareStatement(sql);
	                 ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    Servico servico = new Servico();
	                    servico.setId(rs.getInt("id"));
	                    servico.setDescricao(rs.getString("descricao"));
	                    servico.setPreco(rs.getDouble("preco"));

	                    servicos.add(servico);
	                }
	                rs.close();
	                stmt.close();
	            }
	            return servicos;
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    // Método para atualizar um serviço no banco
	    public void atualizarServico(int id, Servico novosDadosServico) {
	    	if (buscarServicoPorId(id) != null) {
		        String sql = "UPDATE servico SET descricao=?, preco=? WHERE id=?";
		        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
		            stmt.setString(1, novosDadosServico.getDescricao());
		            stmt.setDouble(2, novosDadosServico.getPreco());
		            stmt.setInt(3, id); // Define o ID do serviço a ser atualizado
		            stmt.executeUpdate();
		            System.out.println("Serviço atualizado com sucesso!");
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
	    	}else {
	            System.out.println("Serviço com o ID especificado não encontrado.");
	        }
	    }
	    
	    // Método para deletar um serviço do banco
	    public void deletarServico(int id) {
	    	if (buscarServicoPorId(id) != null) {
		        String sql = "DELETE FROM servico WHERE id=?";
		        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
		            stmt.setInt(1, id);
		            stmt.executeUpdate();
		            System.out.println("Serviço excluído com sucesso!");
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
	    	}else {
	            System.out.println("Serviço com o ID especificado não encontrado.");
	        }
	    }
	    
	 // Método para buscar um serviço por ID
	    public Servico buscarServicoPorId(int id) {
	        String sql = "SELECT * FROM servico WHERE id = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                Servico servico = new Servico();
	                servico.setId(rs.getInt("id"));
	                servico.setDescricao(rs.getString("descricao"));
	                servico.setPreco(rs.getDouble("preco"));
	                return servico;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return null; // Retorna null se nenhum serviço for encontrado com o ID especificado
	    }
}
