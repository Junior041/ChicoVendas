package br.com.unifebe.aulafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

public class TelaLoginController {
    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    private Consumer<String> onLoginSuccess;

    public void setOnLoginSuccess(Consumer<String> callback) {
        this.onLoginSuccess = callback;
    }

    @FXML
    void login(ActionEvent event) {
        // Lógica de autenticação aqui
        String username = txtLogin.getText();
        String password = txtSenha.getText();

        // Exemplo de autenticação simples (usuário "adm" e senha "adm")
        if ("adm".equals(username) && "adm".equals(password)) {
            // Chama o callback com o tipo de usuário
            if (onLoginSuccess != null) {
                onLoginSuccess.accept("adm");

                // Abre a Tela Administrativa
                this.openTelaAdministrativa();
            }
        } else {
            // Exibe uma mensagem de erro em caso de falha na autenticação
            this.openTelaCLiente();
        }
    }
    private void openTelaAdministrativa() {
        try {
            // Carrega o arquivo FXML da Tela Administrativa
            URL url = new File("src/main/java/br/com/unifebe/aulafx/view/View-Adm.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            // Obtém o controlador da Tela Administrativa
            Object telaAdmController = loader.getController();

            // Configura o palco (Stage)
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Administrativa");

            // Exibe o palco
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    }

    private void openTelaCLiente() {
        try {
            // Carrega o arquivo FXML da Tela Administrativa
            URL url = new File("src/main/java/br/com/unifebe/aulafx/view/View-Cliente.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            // Obtém o controlador da Tela Administrativa
            Object telaAdmController = loader.getController();

            // Configura o palco (Stage)
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Cliente");

            // Exibe o palco
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    }

    private void exibirMensagemErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de autenticação");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
