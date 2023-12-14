package br.com.unifebe.aulafx.dao;

import br.com.unifebe.aulafx.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setDouble(3, produto.getQuantidade());
            statement.executeUpdate();
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");
                    double quantidade = resultSet.getDouble("quantidade");
                    Produto produto = new Produto(nome, preco, quantidade);
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public void removerProduto(Produto produto) throws SQLException {
        String sql = "DELETE FROM produtos WHERE nome = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.executeUpdate();
        }
    }

    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET preco = ?, quantidade = ? WHERE nome = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, produto.getPreco());
            statement.setDouble(2, produto.getQuantidade());
            statement.setString(3, produto.getNome());
            statement.executeUpdate();
        }
    }
}
