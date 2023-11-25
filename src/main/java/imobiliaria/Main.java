package imobiliaria;

import java.util.*;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void cadastrarEndereco(List<Endereco> enderecos, Stage primaryStage){

        Text RuaText = new Text("Rua: ");
        RuaText.getStyleClass().add("text");
        TextField ruaInput = new TextField();

        Text NumeroText = new Text("Numero: ");
        NumeroText.getStyleClass().add("text");
        TextField numeroInput = new TextField();

        Text BairroText = new Text("Bairro: ");
        BairroText.getStyleClass().add("text");
        TextField bairroInput = new TextField();

        Text CidadeText = new Text("Cidade: ");
        CidadeText.getStyleClass().add("text");
        TextField cidadeInput = new TextField();

        Text CEPText = new Text("CEP: ");
        CEPText.getStyleClass().add("text");
        TextField CEPInput = new TextField();

        Button submitButton = new Button("Cadastrar");
        submitButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);
            enderecos.add(endereco);

            start(primaryStage);
            
        });


        VBox cadastrar = new VBox(10);
        cadastrar.setAlignment(Pos.CENTER);
        cadastrar.getChildren().addAll(
                RuaText,
                ruaInput,
                NumeroText,
                numeroInput,
                BairroText,
                bairroInput,
                CidadeText,
                cidadeInput,
                CEPText,
                CEPInput,
                submitButton
        );

        Scene scene = new Scene(cadastrar, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Controle de Imóveis");
        List<Endereco> enderecos = new ArrayList<Endereco>();

        Text tittleMenu = new Text("Bem-vindo ao Sistema de Controle de Imóveis");
        Text space01 = new Text("");
        Text space02 = new Text("");

        Button cadastrarClientesButton = new Button("Cadastrar Clientes");
        Button cadastrarCorretoresButton = new Button("Cadastrar Corretores");
        Button cadastrarProprietariosButton = new Button("Cadastrar Proprietarios");
        Button cadastrarContratosButton = new Button("Cadastrar Contratos");
        Button cadastrarImoveisButton = new Button("Cadastrar Imoveis");

        Button listarClientesButton = new Button("Listar Clientes");
        Button listarCorretoresButton = new Button("Listar Corretores");
        Button listarProprietariosButton = new Button("Listar Proprietarios");
        Button listarContratosButton = new Button("Listar Contratos");
        Button listarImoveisDisponiveisButton = new Button("Listar Imóveis Disponíveis");
        Button listarImoveisManutencaoButton = new Button("Listar Imóveis em Manutenção");

        // Aplicar estilos usando CSS
        cadastrarClientesButton.getStyleClass().add("button");
        cadastrarCorretoresButton.getStyleClass().add("button");
        cadastrarProprietariosButton.getStyleClass().add("button");
        cadastrarContratosButton.getStyleClass().add("button");
        cadastrarImoveisButton.getStyleClass().add("button");

        listarClientesButton.getStyleClass().add("button");
        listarCorretoresButton.getStyleClass().add("button");
        listarProprietariosButton.getStyleClass().add("button");
        listarContratosButton.getStyleClass().add("button");
        listarImoveisDisponiveisButton.getStyleClass().add("button");
        listarImoveisManutencaoButton.getStyleClass().add("button");
        tittleMenu.getStyleClass().add("tittle");


        VBox cadastrar = new VBox(10);
        cadastrar.setAlignment(Pos.CENTER);
        cadastrar.getChildren().addAll(
                cadastrarClientesButton,
                cadastrarCorretoresButton,
                cadastrarProprietariosButton,
                cadastrarContratosButton,
                cadastrarImoveisButton
        );

        VBox listar = new VBox(10);
        listar.setAlignment(Pos.CENTER);
        listar.getChildren().addAll(
            listarClientesButton,
            listarCorretoresButton,
            listarProprietariosButton,
            listarContratosButton,
            listarImoveisDisponiveisButton,
            listarImoveisManutencaoButton
        );

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            tittleMenu,
            space01,
            cadastrar,
            space02,
            listar
        );

        Scene scene = new Scene(layout, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        // Adicione a lógica de eventos dos botões conforme necessário

        cadastrarClientesButton.setOnAction(event -> {
            cadastrarEndereco(enderecos, primaryStage);
        });
    }

}
