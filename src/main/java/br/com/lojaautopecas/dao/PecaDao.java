package br.com.lojaautopecas.dao;

import br.com.lojaautopecas.CriacaoTabelas.TabelaPeca;
import br.com.lojaautopecas.jdbc.DBConnection;
import br.com.lojaautopecas.model.Peca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PecaDao {

    private Connection conexao;

    public PecaDao() throws SQLException {
        this.conexao = new DBConnection().getConexao();
    }

    private boolean tabelaPecaExiste() throws SQLException {
        DatabaseMetaData metaData = conexao.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "peca", null);
        return tables.next();
    }

    public void inserirPeca(Peca peca) throws SQLException {

        if (!tabelaPecaExiste()) {
            TabelaPeca tabelaLocacao = new TabelaPeca();
            tabelaLocacao.criar();
        }

        String sql = "INSERT INTO peca (nome, preco) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setDouble(2, peca.getPreco());
            stmt.execute();
            stmt.close();

            System.out.println("Peça criada com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Peca> listarPeca() {
        try {
            List<Peca> pecas = new ArrayList<>();
            String sql = "SELECT * FROM peca ORDER BY id";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setPreco(rs.getDouble("preco"));
                pecas.add(peca);
                System.out.println(peca.getNome());
            }

            rs.close();
            stmt.close();
            return pecas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarPeca(int id, Peca novosDadosPeca) {
        String sql = "UPDATE peca SET nome=?, preco=? WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novosDadosPeca.getNome());
            stmt.setDouble(2, novosDadosPeca.getPreco());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Peca atualizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deletarPeca(int id) {
        String sql = "DELETE FROM peca WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Peca excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  }
