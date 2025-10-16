package ucb.estudo.dao;

import ucb.estudo.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeProdutos implements RepositorioDeProdutosInterface{
    private final ConexaoMySQL conexaoDB;

    public RepositorioDeProdutos(ConexaoMySQL conexaoDB) {
        this.conexaoDB = conexaoDB;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = conexaoDB.obterConexao();
            String sql = "SELECT * FROM produtos";
            stmt = conexao.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque")
                );
                produtos.add(produto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            fecharRecursos(conexao, stmt, rs);
        }

        return produtos;
    }

    private void fecharRecursos(Connection conexao, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }
}
