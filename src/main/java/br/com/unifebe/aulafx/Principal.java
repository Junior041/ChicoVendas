package br.com.unifebe.aulafx;

import br.com.unifebe.aulafx.controller.TelaLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("src/main/java/br/com/unifebe/aulafx/view/View-Login.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Obtém o controlador da tela de login
        TelaLoginController telaLoginController = loader.getController();

        // Define o método que será chamado ao ter sucesso no login
        telaLoginController.setOnLoginSuccess(userType -> {
            try {
                // Decide qual tela exibir com base no tipo de usuário
                if (userType.equals("adm")) {
                    // Exibe a tela de administrador
                    URL urlAdmin = new File("src/main/java/br/com/unifebe/aulafx/view/View-Adm.fxml").toURI().toURL();
                    FXMLLoader admLoader = new FXMLLoader(urlAdmin);
                    Parent admRoot = admLoader.load();
                    Scene admScene = new Scene(admRoot);
                    stage.setScene(admScene);
                } else if (userType.equals("cliente")) {
                    // Exibe a tela de cliente
                    FXMLLoader clienteLoader = new FXMLLoader(getClass().getResource("/src/main/java/br/com/unifebe/aulafx/view/View-Cliente.fxml"));
                    Parent clienteRoot = clienteLoader.load();
                    Scene clienteScene = new Scene(clienteRoot);
                    stage.setScene(clienteScene);
                } else {
                    // Trate outros tipos de usuários conforme necessário
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

    public static void main(String[] args) {
        launch();
    }
}
