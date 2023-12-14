package br.com.unifebe.aulafx.dao;

import br.com.unifebe.aulafx.model.CarrinhoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    private final Connection connection;

    public CarrinhoDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarItem(CarrinhoItem item) throws SQLException {
        String sql = "INSERT INTO carrinho (produto_nome, quantidade) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getProdutoNome());
            statement.setInt(2, item.getQuantidade());
            statement.executeUpdate();
        }
    }

    public List<CarrinhoItem> listarItens() throws SQLException {
        List<CarrinhoItem> itens = new ArrayList<>();
        String sql = "SELECT * FROM carrinho";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String produtoNome = resultSet.getString("produto_nome");
                    int quantidade = resultSet.getInt("quantidade");
                    CarrinhoItem item = new CarrinhoItem(produtoNome, quantidade);
                    itens.add(item);
                }
            }
        }
        return itens;
    }

    public void removerItem(CarrinhoItem item) throws SQLException {
        String sql = "DELETE FROM carrinho WHERE produto_nome = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, item.getProdutoNome());
            statement.executeUpdate();
        }
    }

    public void confirmarCompra() {
        // Lógica para confirmar a compra no banco de dados
    }
}
