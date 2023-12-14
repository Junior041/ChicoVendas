package br.com.unifebe.aulafx.controller;

import br.com.unifebe.aulafx.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaAdministrativaController {

    @FXML
    private Button btnCadastrarProduto;

    @FXML
    private Button btnBuscarProduto;

    @FXML
    private Button btnRemoverProduto;

    @FXML
    private Button btnAtualizarProduto;

    @FXML
    private TextField txtInserirProduto;

    @FXML
    private TextField txtQuantidadeProduto;

    @FXML
    private TextField txtBuscarProduto;

    @FXML
    private TextField txtPreco;

    @FXML
    private TableView tabela;

    @FXML
    private TableColumn colNomeProdutoCadastro;

    @FXML
    private TableColumn colQuantidade;

    @FXML
    private TableColumn colPreco;

    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();


    // Método para cadastrar produto
    @FXML
    public void cadastrarProduto() {


    }

    public void inserir(){
        String nomeProduto = txtInserirProduto.getText();
        int quantidade = Integer.parseInt(txtQuantidadeProduto.getText());
        double preco = Double.parseDouble(txtPreco.getText());
        Produto produto = new Produto(nomeProduto, quantidade, preco);
        this.inserirNaTabela(produto);
        //salvar no banco
    }

    // Método para buscar produto
    @FXML
    public void buscarProduto() {
        String nomeProduto = txtBuscarProduto.getText();

        // Lógica para buscar produto
        // Aqui você pode usar o nome do produto para realizar a busca
        System.out.println("Buscando produto: " + nomeProduto);
    }

    // Método para remover produto
    @FXML
    public void removerProduto() {
        // Lógica para remover produto
        // Aqui você pode implementar a lógica de remoção do produto selecionado na tabela
        System.out.println("Removendo produto");
    }

    // Método para atualizar produto
    @FXML
    public void atualizarProduto() {
        // Lógica para atualizar produto
        // Aqui você pode implementar a lógica de atualização do produto selecionado na tabela
        System.out.println("Atualizando produto");
    }


    public void pegaProdutosDoBancoEPoeNaTabela(){
        // pegar os produtos do banco, fazer um foreach e chamar a inserir inserirNaTabela para cada produto
    }

    public void inserirNaTabela(Produto produto){
        listaProdutos.add(produto);
        // Definindo os dados na tabela
        colNomeProdutoCadastro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        // Definindo a lista de produtos na tabela
        tabela.setItems(listaProdutos);
    }



}