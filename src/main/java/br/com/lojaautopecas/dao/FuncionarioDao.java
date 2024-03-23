package br.com.lojaautopecas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaautopecas.CriacaoTabelas.TabelaFuncionario;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Funcionario;

public class FuncionarioDao {
	private Connection conexao;

    public FuncionarioDao() {
        this.conexao = new DBConnection().getConexao();
    }

    // Método para verificar se a tabela Funcionario já existe no banco
    private boolean tabelaFuncionarioExiste() throws SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "funcionario", null);
        return tables.next();
    }

    // Método para inserir um funcionário no banco
    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        if (!tabelaFuncionarioExiste()) {
            TabelaFuncionario tabelaFuncionario = new TabelaFuncionario();
            tabelaFuncionario.criar();
        }

        String sql = "INSERT INTO funcionario (cpf, nome, cargo, usuario, senha) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(5, funcionario.getSenha());
            stmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para listar todos os funcionários do banco
    public List<Funcionario> listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();
            String sql = "SELECT * FROM Funcionario ORDER BY id";

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getInt("id"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCargo(rs.getString("cargo"));

                    funcionarios.add(funcionario);
                }
                rs.close();
                stmt.close();
            }
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para atualizar um funcionário no banco
    public void atualizarFuncionario(Integer id, Funcionario novoFuncionario) {
        String sql = "UPDATE Funcionario SET cpf=?, nome=?, cargo=?, usuario=?, senha=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novoFuncionario.getCpf());
            stmt.setString(2, novoFuncionario.getNome());
            stmt.setString(3, novoFuncionario.getCargo());
            stmt.setString(5, novoFuncionario.getSenha());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Funcionário atualizado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para deletar um funcionário do banco
    public void deletarFuncionario(Integer id) {
        String sql = "DELETE FROM Funcionario WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Funcionário excluído com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Metodo que validará os dados de login do funcionario   
    public boolean validarCpfSenha(String cpf, String senha) {
        String sql = "SELECT senha FROM Funcionario WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaBanco = rs.getString("senha");
                return senhaBanco.equals(senha);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    
    // Metodo para buscar um funcionario por ID
    public Funcionario buscarFuncionarioPorId(int id) {
        String sql = "SELECT * FROM Funcionario WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSenha(rs.getString("senha"));
                return funcionario;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se nenhum funcionário for encontrado com o ID especificado
    }
}