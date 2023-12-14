package br.com.unifebe.aulafx.controller;

import br.com.unifebe.aulafx.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaClienteController {

    @FXML
    private Button btnBuscarProduto;

    @FXML
    private TextField txtBuscarProduto;

    @FXML
    private Button btnAdicionarCarrinho;

    @FXML
    private Button btnRetirarCarrinho;

    @FXML
    private Button btnConfirmarCompra;

    @FXML
    private TableColumn colProdutoCarrinho;

    @FXML
    private TableColumn colQuantidadeCarrinho;

    @FXML
    private TableColumn colProdutoBusca;

    @FXML
    private TableColumn colQuantidade;

    @FXML
    private TableColumn colPrecoCliente;

    @FXML
    private TableView tabela;

    @FXML
    private TableView<Produto> tabelaCarrinho;
    @FXML
    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();

    @FXML
    private ObservableList<Produto> listaCarrinho = FXCollections.observableArrayList();


    // Implemente os métodos de ação correspondentes

    public void adicionarCarrinho() {
        // Lógica para adicionar ao carrinho
        int index = tabela.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Produto produtoParaAdicionar = listaProdutos.get(index);
            listaCarrinho.add(produtoParaAdicionar);
            // Definindo os dados na tabela
            colProdutoCarrinho.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colQuantidadeCarrinho.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

            // Definindo a lista de produtos na tabela
            tabelaCarrinho.setItems(listaProdutos);

        } else {
            System.out.println("Produto nao encontrado");
        }
    }

    public void retirarCarrinho() {
        //remove o produto do carinho
        tabelaCarrinho.getItems().remove(tabelaCarrinho.getSelectionModel().getSelectedIndex());
        System.out.println("Removendo produto do carrinho");
    }

    public void confirmarCompra() {
        // Lógica para confirmar compra
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Compra confirmada com Sucesso.");
            alert.setHeaderText(null);
            alert.setContentText("Sua Compra foi confirmada.");
            alert.showAndWait();
            listaCarrinho.removeAll();
    }

    @FXML
    public void buscarProduto() {
        String nomeProduto = txtBuscarProduto.getText().toUpperCase();
        this.inserir();
        // limpa a tabela, busca os produtos no banco, chama o inserirNaTabela para cada um deles
        // SELECT * FROM PRODUTOS LIKE "%{nomeProduto}%";
    }

    public void buscarProdutosBanco(){
        //buscar os produtos que o admin cadastrou no banco, e pra cada, chama o inserir (para inserir na tabela de produtos)
    }

    public void inserir(){
        Produto produto = new Produto("nomeProduto", 10, 100);
        this.inserirNaTabela(produto);
        //salvar no banco
    }
    public void inserirNaTabela(Produto produto){
        listaProdutos.add(produto);
        // Definindo os dados na tabela
        colProdutoBusca.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPrecoCliente.setCellValueFactory(new PropertyValueFactory<>("preco"));

        // Definindo a lista de produtos na tabela
        tabela.setItems(listaProdutos);
    }
}
