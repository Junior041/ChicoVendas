package br.com.unifebe.aulafx.controller;

import br.com.unifebe.aulafx.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.function.Predicate;

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
        String nomeProduto = txtBuscarProduto.getText().toUpperCase();
        // limpa a tabela, busca os produtos no banco, chama o inserirNaTabela para cada um deles
        // SELECT * FROM PRODUTOS LIKE "%{nomeProduto}%";
    }

    // Método para remover produto
    @FXML
    public void removerProduto() {
        //aagar no banco, caso de certo faça o codigo a baixo
        tabela.getItems().remove(tabela.getSelectionModel().getSelectedIndex());
        System.out.println("Removendo produto");
    }

    // Método para atualizar produto
    @FXML
    public void atualizarProduto() {
        int index = tabela.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            //alterar no banco, caso de certo faça o código a baixo
            Produto itemParaSerAlterado = listaProdutos.get(index);
            itemParaSerAlterado.setNome(txtInserirProduto.getText());
            itemParaSerAlterado.setPreco(Double.parseDouble(txtPreco.getText()));
            itemParaSerAlterado.setQuantidade(Integer.parseInt(txtQuantidadeProduto.getText()));
            tabela.refresh(); // Atualiza a exibição da tabela
            System.out.println("Produto atualizado: " + itemParaSerAlterado.getNome());
        } else {
            System.out.println("Selecione um produto para atualizar.");
        }
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