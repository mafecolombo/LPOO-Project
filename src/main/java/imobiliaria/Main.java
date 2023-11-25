package imobiliaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }









    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Controle de Imóveis");

        Text tittleMenu = new Text("Bem-vindo ao Sistema de Controle de Imóveis");
        Text space = new Text("");

        Button listarClientesButton = new Button("Listar Clientes");
        Button listarContratosButton = new Button("Listar Contratos");
        Button listarImoveisDisponiveisButton = new Button("Listar Imóveis Disponíveis");
        Button listarImoveisManutencaoButton = new Button("Listar Imóveis em Manutenção");

        // Aplicar estilos usando CSS
        listarClientesButton.getStyleClass().add("button");
        listarContratosButton.getStyleClass().add("button");
        listarImoveisDisponiveisButton.getStyleClass().add("button");
        listarImoveisManutencaoButton.getStyleClass().add("button");
        tittleMenu.getStyleClass().add("tittle");


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                tittleMenu,
                space,
                listarClientesButton,
                listarContratosButton,
                listarImoveisDisponiveisButton,
                listarImoveisManutencaoButton
        );

        Scene scene = new Scene(layout, 500, 250);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        // Adicione a lógica de eventos dos botões conforme necessário
    }

}
