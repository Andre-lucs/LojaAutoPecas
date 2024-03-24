package br.com.lojaautopecas.dao;

import br.com.lojaautopecas.CriacaoTabelas.TabelaCliente;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    
    private Connection conexao;

    public ClienteDao() throws SQLException {
        this.conexao = new DBConnection().getConexao();
    }

    private boolean tabelaClienteExiste() throws SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "cliente", null);
        return tables.next();
    }

    public void inserirCliente(Cliente cliente) throws SQLException {

        System.out.println(cliente.getNome());

        if (!tabelaClienteExiste()) {
            TabelaCliente tabelaCliente = new TabelaCliente();
            tabelaCliente.criar();
        }

        String sql = "INSERT INTO cliente (cpf, nome, id_veiculo) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getId_Veiculo());
            stmt.execute();
            stmt.close();

            System.out.println("CLiente criado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarCliente() {
        try {
            List<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM cliente ORDER BY id";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setId_Veiculo(rs.getInt("id"));
                clientes.add(cliente);
                System.out.println(cliente.getNome());
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarCliente(int id, Cliente novosDadosCliente) {

        System.out.println(novosDadosCliente.getNome());
        if (buscarClientePorId(id) != null) {
            String sql = "UPDATE cliente SET cpf=?, nome=?, id_veiculo=? WHERE id=?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, novosDadosCliente.getCpf());
                stmt.setString(2, novosDadosCliente.getNome());
                stmt.setInt(3, novosDadosCliente.getId_Veiculo());
                stmt.setInt(4, id);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Cliente atualizado com sucesso!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Cliente com o ID especificado não encontrado.");
        }

    }


    public void deletarCliente(int id) {
        if (buscarClientePorId(id) != null) {
            String sql = "DELETE FROM cliente WHERE id=?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Cliente excluído com sucesso!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Cliente com o ID especificado não encontrado.");
        }
    }

    public Cliente buscarClientePorId (int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setId_Veiculo(rs.getInt("id_veiculo"));
                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}