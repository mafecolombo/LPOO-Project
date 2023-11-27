package imobiliaria;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Main extends Application {

    public void menu(Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        Text tittleMenu = new Text("Bem-vindo ao Sistema de Controle de Imóveis");
        Text space01 = new Text("");
        Text space02 = new Text("");

        Button cadastrarContratosButton = new Button("Cadastrar Contrato");
        Button cadastrarContratosComerciaisButton = new Button("Cadastrar Contrato Comercial");

        Button listarClientesButton = new Button("Listar Clientes");
        Button listarCorretoresButton = new Button("Listar Corretores");
        Button listarProprietariosButton = new Button("Listar Proprietarios");
        Button listarContratosComerciaisButton = new Button("Listar Contratos Comerciais");
        Button listarContratosButton = new Button("Listar Contratos");
        Button listarImoveisDisponiveisButton = new Button("Listar Imóveis Disponíveis");
        Button listarImoveisManutencaoButton = new Button("Listar Imóveis em Manutenção");

        // Aplicar estilos usando CSS
        cadastrarContratosButton.getStyleClass().add("button");
        cadastrarContratosComerciaisButton.getStyleClass().add("button");

        listarClientesButton.getStyleClass().add("button");
        listarCorretoresButton.getStyleClass().add("button");
        listarProprietariosButton.getStyleClass().add("button");
        listarContratosButton.getStyleClass().add("button");
        listarContratosComerciaisButton.getStyleClass().add("button");
        listarImoveisDisponiveisButton.getStyleClass().add("button");
        listarImoveisManutencaoButton.getStyleClass().add("button");
        tittleMenu.getStyleClass().add("tittle");


        VBox cadastrar = new VBox(10);
        cadastrar.setAlignment(Pos.CENTER);
        cadastrar.getChildren().addAll(
                cadastrarContratosButton,
                cadastrarContratosComerciaisButton
        );

        VBox listar = new VBox(10);
        listar.setAlignment(Pos.CENTER);
        listar.getChildren().addAll(
            listarClientesButton,
            listarCorretoresButton,
            listarProprietariosButton,
            listarContratosButton,
            listarContratosComerciaisButton,
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
        cadastrarContratosButton.setOnAction(event -> {
            cadastrarContrato(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
        });

        cadastrarContratosComerciaisButton.setOnAction(event -> {
            cadastrarContratoComercial(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
        });

        listarClientesButton.setOnAction(event -> {
            listarclientes(clientes, primaryStage,enderecos,corretores,proprietarios,contratosComerciais,contratosAlugueis,imoveisDisp,imoveisManu,tiposImoveis);
            //System.out.println(clientes.get(0));
        });

        listarCorretoresButton.setOnAction(event ->{
            listarCorretores(corretores,primaryStage,enderecos,clientes,proprietarios,contratosComerciais,contratosAlugueis,imoveisDisp,imoveisManu,tiposImoveis);
        });

        listarProprietariosButton.setOnAction(event ->{
            listarProprietarios(proprietarios,primaryStage,enderecos,clientes,corretores,contratosComerciais,contratosAlugueis,imoveisDisp,imoveisManu,tiposImoveis);
        });

        listarImoveisDisponiveisButton.setOnAction(event->{
            listarImoveisDisp(imoveisDisp, primaryStage, enderecos, corretores, proprietarios, contratosComerciais, contratosAlugueis, clientes, imoveisManu, tiposImoveis);
        });

        listarImoveisManutencaoButton.setOnAction(event->{
            listarImoveisManu(imoveisManu, primaryStage, enderecos, corretores, proprietarios, contratosComerciais, contratosAlugueis, clientes, imoveisDisp, tiposImoveis);
        });

        listarContratosButton.setOnAction(event -> {
           listarContratos(contratosAlugueis, contratosComerciais, primaryStage, enderecos, corretores, proprietarios, clientes, imoveisDisp, imoveisManu, tiposImoveis);
        });

        listarContratosComerciaisButton.setOnAction(event -> {
            listarContratosComerciais(contratosAlugueis, contratosComerciais, primaryStage, enderecos, corretores, proprietarios, clientes, imoveisDisp, imoveisManu, tiposImoveis);
        });
    }

    public void listarclientes(ArrayList<Cliente> clientes, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<Cliente> table = new TableView<>();
        
        TableColumn<Cliente, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        TableColumn<Cliente, String> cpfCol = new TableColumn<>("CPF");
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        TableColumn<Cliente, String> rgCol = new TableColumn<>("RG");
        rgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        
        TableColumn<Cliente, String> enderecoCol = new TableColumn<>("Endereco");
        enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        TableColumn<Cliente, String> celularCol = new TableColumn<>("Celular");
        celularCol.setCellValueFactory(new PropertyValueFactory<>("celular"));
        
        TableColumn<Cliente, String> dataNascimentoCol = new TableColumn<>("Data de Nascimento");
        dataNascimentoCol.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        
        TableColumn<Cliente, Integer> pontuacaoCol = new TableColumn<>("Pontuacao");
        pontuacaoCol.setCellValueFactory(new PropertyValueFactory<>("pontuacao"));
        
        table.getColumns().addAll(nomeCol, cpfCol, rgCol, enderecoCol, celularCol, dataNascimentoCol, pontuacaoCol);
    
        // Populate table with clients
        table.getItems().addAll(clientes);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void listarCorretores(ArrayList<Corretor> corretores, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<Corretor> table = new TableView<>();
        
        TableColumn<Corretor, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        TableColumn<Corretor, String> cpfCol = new TableColumn<>("CPF");
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        TableColumn<Corretor, String> rgCol = new TableColumn<>("RG");
        rgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        
        TableColumn<Corretor, String> enderecoCol = new TableColumn<>("Endereco");
        enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        TableColumn<Corretor, String> celularCol = new TableColumn<>("Celular");
        celularCol.setCellValueFactory(new PropertyValueFactory<>("celular"));
        
        TableColumn<Corretor, String> dataNascimentoCol = new TableColumn<>("Data de Nascimento");
        dataNascimentoCol.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        
        TableColumn<Corretor, String> creciCol = new TableColumn<>("Creci");
        creciCol.setCellValueFactory(new PropertyValueFactory<>("creci"));
        
        table.getColumns().addAll(nomeCol, cpfCol, rgCol, enderecoCol, celularCol, dataNascimentoCol, creciCol);
    
        // Populate table with clients
        table.getItems().addAll(corretores);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void listarProprietarios(ArrayList<Proprietario> proprietarios, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<Proprietario> table = new TableView<>();
        
        TableColumn<Proprietario, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        TableColumn<Proprietario, String> cpfCol = new TableColumn<>("CPF");
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        TableColumn<Proprietario, String> rgCol = new TableColumn<>("RG");
        rgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        
        TableColumn<Proprietario, String> enderecoCol = new TableColumn<>("Endereco");
        enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        TableColumn<Proprietario, String> celularCol = new TableColumn<>("Celular");
        celularCol.setCellValueFactory(new PropertyValueFactory<>("celular"));
        
        TableColumn<Proprietario, String> dataNascimentoCol = new TableColumn<>("Data de Nascimento");
        dataNascimentoCol.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        
        TableColumn<Proprietario, String> pixCol = new TableColumn<>("Pix");
        pixCol.setCellValueFactory(new PropertyValueFactory<>("pix"));
        
        table.getColumns().addAll(nomeCol, cpfCol, rgCol, enderecoCol, celularCol, dataNascimentoCol, pixCol);
    
        // Populate table with clients
        table.getItems().addAll(proprietarios);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void listarImoveisDisp(ArrayList<Imovel> imoveisDisp, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Cliente> clientes, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<Imovel> table = new TableView<>();
        
        TableColumn<Imovel, TipoImovel> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        
        TableColumn<Imovel, Endereco> enderecoCol = new TableColumn<>("Endereco");
        enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        TableColumn<Imovel, Double> areaCol = new TableColumn<>("Area");
        areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
        
        TableColumn<Imovel, Double> precoCol = new TableColumn<>("Preco");
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));
        
        TableColumn<Imovel, Proprietario> proprietarioCol = new TableColumn<>("Proprietario");
        proprietarioCol.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
        
        table.getColumns().addAll(tipoCol, enderecoCol, areaCol, precoCol, proprietarioCol);
    
        // Populate table with properties
        table.getItems().addAll(imoveisDisp);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void listarImoveisManu(ArrayList<Imovel> imoveisManu, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Cliente> clientes, ArrayList<Imovel> imoveisDisp, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<Imovel> table = new TableView<>();
        
        TableColumn<Imovel, TipoImovel> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        
        TableColumn<Imovel, Endereco> enderecoCol = new TableColumn<>("Endereco");
        enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        TableColumn<Imovel, Double> areaCol = new TableColumn<>("Area");
        areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
        
        TableColumn<Imovel, Double> precoCol = new TableColumn<>("Preco");
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));
        
        TableColumn<Imovel, Proprietario> proprietarioCol = new TableColumn<>("Proprietario");
        proprietarioCol.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
        
        table.getColumns().addAll(tipoCol, enderecoCol, areaCol, precoCol, proprietarioCol);
    
        // Populate table with properties
        table.getItems().addAll(imoveisManu);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void listarContratos(ArrayList<ContratoAluguel<String>> contratosAluguel, ArrayList<ContratoAluguelComercial> contratosComerciais, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<Cliente> clientes, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        // Create table and columns
        TableView<ContratoAluguel<String>> table = new TableView<>();
        
        TableColumn<ContratoAluguel<String>, Imovel> imovelCol = new TableColumn<>("Imovel");
        imovelCol.setCellValueFactory(new PropertyValueFactory<>("imovel"));
        
        TableColumn<ContratoAluguel<String>, Corretor> corretorCol = new TableColumn<>("Corretor");
        corretorCol.setCellValueFactory(new PropertyValueFactory<>("corretor"));
        
        TableColumn<ContratoAluguel<String>, Cliente> clienteCol = new TableColumn<>("Cliente");
        clienteCol.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        
        TableColumn<ContratoAluguel<String>, String> tempoCol = new TableColumn<>("Tempo");
        tempoCol.setCellValueFactory(new PropertyValueFactory<>("tempo"));
        
        TableColumn<ContratoAluguel<String>, Double> valorCol = new TableColumn<>("Valor");
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));
        
        table.getColumns().addAll(imovelCol, corretorCol, clienteCol, tempoCol, valorCol);
    
        // Populate table with contracts
        table.getItems().addAll(contratosAluguel);
    
        // Create button to return to primary stage
        Button returnButton = new Button("Return");
        returnButton.setOnAction(event -> {
            menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAluguel, imoveisDisp, imoveisManu, tiposImoveis);
            // Code to return to primary stage goes here
        });
    
        // Create VBox to hold table and button
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, returnButton);
    
        // Create scroll pane and add VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    
        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
        table.prefWidthProperty().bind(scene.widthProperty().multiply(1));
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void listarContratosComerciais(ArrayList<ContratoAluguel<String>> contratosAluguel, ArrayList<ContratoAluguelComercial> contratosComerciais, Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<Cliente> clientes, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
    // Create table and columns
    TableView<ContratoAluguelComercial> table = new TableView<>();
    
    TableColumn<ContratoAluguelComercial, Imovel> imovelCol = new TableColumn<>("Imovel");
    imovelCol.setCellValueFactory(new PropertyValueFactory<>("imovel"));
    
    TableColumn<ContratoAluguelComercial, Corretor> corretorCol = new TableColumn<>("Corretor");
    corretorCol.setCellValueFactory(new PropertyValueFactory<>("corretor"));
    
    TableColumn<ContratoAluguelComercial, Cliente> clienteCol = new TableColumn<>("Cliente");
    clienteCol.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    
    TableColumn<ContratoAluguelComercial, String> tempoCol = new TableColumn<>("Tempo");
    tempoCol.setCellValueFactory(new PropertyValueFactory<>("tempo"));
    
    TableColumn<ContratoAluguelComercial, Double> valorCol = new TableColumn<>("Valor");
    valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));
    
    table.getColumns().addAll(imovelCol, corretorCol, clienteCol, tempoCol, valorCol);

    // Populate table with contracts
    table.getItems().addAll(contratosComerciais);

    // Create button to return to primary stage
    Button returnButton = new Button("Return");
    returnButton.setOnAction(event -> {
        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAluguel, imoveisDisp, imoveisManu, tiposImoveis);
        // Code to return to primary stage goes here
    });

    // Create VBox to hold table and button
    VBox vbox = new VBox();
    vbox.getChildren().addAll(table, returnButton);

    // Create scroll pane and add VBox to it
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(vbox);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    Scene scene = new Scene(scrollPane, 1000, 500);
    scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());
    table.prefWidthProperty().bind(scene.widthProperty().multiply(1));

    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }

    public void cadastrarContratoComercial(Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){

        Text situacaoText = new Text("Situação do imóvel: insira 'EM MANUTENÇÃO' ou 'DISPONÍVEL");
        situacaoText.getStyleClass().add("text");
        TextField sitInput = new TextField();



        Text tittle = new Text("Contrato Aluguel Comercial");
        tittle.getStyleClass().add("tittle");

        Text imovelTittle = new Text("INFORMAÇÕES DO IMÓVEL");
        imovelTittle.getStyleClass().add("text");
            Text tipoText = new Text("Tipo de Imóvel: ");
            tipoText.getStyleClass().add("text");
            TextField tipoInput = new TextField();

            Text enderecoImoTitle = new Text("ENDEREÇO DO IMÓVEL");
            enderecoImoTitle.getStyleClass().add("text");
                Text RuaImoText = new Text("Rua: ");
                RuaImoText.getStyleClass().add("text");
                TextField ruaImoInput = new TextField();

                Text NumeroImoText = new Text("Numero: ");
                NumeroImoText.getStyleClass().add("text");
                TextField numeroImoInput = new TextField();

                Text BairroImoText = new Text("Bairro: ");
                BairroImoText.getStyleClass().add("text");
                TextField bairroImoInput = new TextField();

                Text CidadeImoText = new Text("Cidade: ");
                CidadeImoText.getStyleClass().add("text");
                TextField cidadeImoInput = new TextField();

                Text CEPImoText = new Text("CEP: ");
                CEPImoText.getStyleClass().add("text");
                TextField CEPImoInput = new TextField();

            Text areaText = new Text("Área: ");
            areaText.getStyleClass().add("text");
            TextField areaInput = new TextField();

            Text precoText = new Text("Preço: ");
            precoText.getStyleClass().add("text");
            TextField precoInput = new TextField();

        Text corretorTitle = new Text("INFORMAÇÕES DO CORRETOR");
        corretorTitle.getStyleClass().add("text");
            Text nomeCorreText = new Text("Nome: ");
            nomeCorreText.getStyleClass().add("text");
            TextField nomeCorreInput = new TextField();

            Text cpfCorreText = new Text("CPF: ");
            cpfCorreText.getStyleClass().add("text");
            TextField cpfCorreInput = new TextField();

            Text rgCorreText = new Text("RG: ");
            rgCorreText.getStyleClass().add("text");
            TextField rgCorreInput = new TextField();

            Text enderecoCorreTittle = new Text("ENDEREÇO DO CORRETOR");
            enderecoCorreTittle.getStyleClass().add("text");
                Text RuaCorreText = new Text("Rua: ");
                RuaCorreText.getStyleClass().add("text");
                TextField ruaCorreInput = new TextField();

                Text NumeroCorreText = new Text("Numero: ");
                NumeroCorreText.getStyleClass().add("text");
                TextField numeroCorreInput = new TextField();

                Text BairroCorreText = new Text("Bairro: ");
                BairroCorreText.getStyleClass().add("text");
                TextField bairroCorreInput = new TextField();

                Text CidadeCorreText = new Text("Cidade: ");
                CidadeCorreText.getStyleClass().add("text");
                TextField cidadeCorreInput = new TextField();

                Text CEPCorreText = new Text("CEP: ");
                CEPCorreText.getStyleClass().add("text");
                TextField CEPCorreInput = new TextField();

            Text celularCorreText = new Text("Celular: ");
            celularCorreText.getStyleClass().add("text");
            TextField celularCorreInput = new TextField();

            Text dataCorreText = new Text("Data de nascimento: ");
            dataCorreText.getStyleClass().add("text");
            TextField dataCorreInput = new TextField();

            Text creciText = new Text("Creci: ");
            creciText.getStyleClass().add("text");
            TextField creciInput = new TextField();

        Text proprietarioTitle = new Text("INFORMAÇÕES DO PROPRIETÁRIO");
        proprietarioTitle.getStyleClass().add("text");
            Text nomePropText = new Text("Nome: ");
            nomePropText.getStyleClass().add("text");
            TextField nomeProInput = new TextField();

            Text cpfProText = new Text("CPF: ");
            cpfProText.getStyleClass().add("text");
            TextField cpfPropInput = new TextField();

            Text rgPropText = new Text("RG: ");
            rgPropText.getStyleClass().add("text");
            TextField rgPropInput = new TextField();

            Text enderecoPropTittle = new Text("ENDEREÇO DO PROPRIETÁRIO");
            enderecoPropTittle.getStyleClass().add("text");
                Text RuaPropText = new Text("Rua: ");
                RuaPropText.getStyleClass().add("text");
                TextField ruaPropInput = new TextField();

                Text NumeroPropText = new Text("Numero: ");
                NumeroPropText.getStyleClass().add("text");
                TextField numeroPropInput = new TextField();

                Text BairroPropText = new Text("Bairro: ");
                BairroPropText.getStyleClass().add("text");
                TextField bairroPropInput = new TextField();

                Text CidadePropText = new Text("Cidade: ");
                CidadePropText.getStyleClass().add("text");
                TextField cidadePropInput = new TextField();

                Text CEPPropText = new Text("CEP: ");
                CEPPropText.getStyleClass().add("text");
                TextField CEPPropInput = new TextField();

            Text celularPropText = new Text("Celular: ");
            celularPropText.getStyleClass().add("text");
            TextField celularPropInput = new TextField();

            Text dataPropText = new Text("Data de nascimento: ");
            dataPropText.getStyleClass().add("text");
            TextField dataPropInput = new TextField();

            Text pixText = new Text("Pix: ");
            pixText.getStyleClass().add("text");
            TextField pixInput = new TextField();


        Text clienteTitle = new Text("INFORMAÇÕES DO CLIENTE");
        clienteTitle.getStyleClass().add("text");
            Text nomeText = new Text("Nome: ");
            nomeText.getStyleClass().add("text");
            TextField nomeInput = new TextField();

            Text cpfText = new Text("CPF: ");
            cpfText.getStyleClass().add("text");
            TextField cpfInput = new TextField();

            Text rgText = new Text("RG: ");
            rgText.getStyleClass().add("text");
            TextField rgInput = new TextField();

            Text enderecoTittle = new Text("ENDEREÇO DO CLIENTE");
            enderecoTittle.getStyleClass().add("text");
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

            Text celularText = new Text("Celular: ");
            celularText.getStyleClass().add("text");
            TextField celularInput = new TextField();

            Text dataText = new Text("Data de nascimento: ");
            dataText.getStyleClass().add("text");
            TextField dataInput = new TextField();

            Text pontText = new Text("Pontuação: ");
            pixText.getStyleClass().add("text");
            TextField pontInput = new TextField();

        Text tempoText = new Text("Tempo: ");
        tempoText.getStyleClass().add("text");
        TextField tempoInput = new TextField();

        Text valorText = new Text("Valor: ");
        valorText.getStyleClass().add("text");
        TextField valorInput = new TextField();

        Text razaoText = new Text("Razão social: ");
        razaoText.getStyleClass().add("text");
        TextField razaoInput = new TextField();

        Text cpnjText = new Text("CNPJ: ");
        cpnjText.getStyleClass().add("text");
        TextField cpnjInput = new TextField(); 
            
        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
            tittle,
            tempoText,
            tempoInput,
            valorText,
            valorInput,
            razaoText,
            razaoInput,
            cpnjText,
            cpnjInput,
            imovelTittle,
                tipoText,
                tipoInput,
                enderecoImoTitle,
                    RuaImoText,
                    ruaImoInput,
                    NumeroImoText,
                    numeroImoInput,
                    BairroImoText,
                    bairroImoInput,
                    CidadeImoText,
                    cidadeImoInput,
                    CEPImoText,
                    CEPImoInput,
                    areaText,
                    areaInput,
                    precoText,
                    precoInput,
                    situacaoText,
                    sitInput,
            proprietarioTitle,
                nomePropText,
                nomeProInput,                
                cpfProText,
                cpfPropInput,
                rgPropText,
                rgPropInput,
                celularPropText,
                celularPropInput,
                dataPropText,
                dataPropInput,
                pixText,
                pixInput,
                enderecoPropTittle,
                    RuaPropText,
                    ruaPropInput,
                    NumeroPropText,
                    numeroPropInput,
                    BairroPropText,
                    bairroPropInput,
                    CidadePropText,
                    cidadePropInput,
                    CEPPropText,
                    CEPPropInput,
            clienteTitle,
                nomeText,
                nomeInput,                
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                celularText,
                celularInput,
                dataText,
                dataInput,
                pontText,
                pontInput,
                enderecoTittle,
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
            corretorTitle,
                nomeCorreText,
                nomeCorreInput,                
                cpfCorreText,
                cpfCorreInput,
                rgCorreText,
                rgCorreInput,
                celularCorreText,
                celularCorreInput,
                dataCorreText,
                dataCorreInput,
                creciText,
                creciInput,
                enderecoCorreTittle,
                    RuaCorreText,
                    ruaCorreInput,
                    NumeroCorreText,
                    numeroCorreInput,
                    BairroCorreText,
                    bairroCorreInput,
                    CidadeCorreText,
                    cidadeCorreInput,
                    CEPCorreText,
                    CEPCorreInput,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();


        submitButton.setOnAction(event -> {

            try{
            
                String numImovel = numeroImoInput.getText();
                int numeroI = Integer.parseInt(numImovel);

                String areaStr = areaInput.getText();
                double area = Double.parseDouble(areaStr);

                String precoStr = precoInput.getText();
                double preco = Double.parseDouble(precoStr);

                String valorStr = valorInput.getText();
                double valor = Double.parseDouble(valorStr);
            
                String numCorre = numeroCorreInput.getText();
                int numeroC = Integer.parseInt(numCorre);
            
                String num = numeroInput.getText();
                int numero = Integer.parseInt(num);

                String numPro = numeroPropInput.getText();
                int numeroP = Integer.parseInt(numPro);

                String pont = pontInput.getText();
                int pontuacao = Integer.parseInt(pont);


                String ruaProp = ruaPropInput.getText();

                String bairroProp = bairroPropInput.getText();

                String cidadeProp = cidadePropInput.getText();

                String CEPProp = CEPPropInput.getText();

                
                String ruaImo = ruaImoInput.getText();

                String bairroImo = bairroImoInput.getText();

                String cidadeImo = cidadeImoInput.getText();

                String CEPImo = CEPImoInput.getText();

                
                String ruaCo = ruaCorreInput.getText();

                String bairroCo = bairroCorreInput.getText();

                String cidadeCo = cidadeCorreInput.getText();

                String CEPCo = CEPCorreInput.getText();


                String rua = ruaInput.getText();

                String bairro = bairroInput.getText();

                String cidade = cidadeInput.getText();

                String CEP = CEPInput.getText();


                TipoImovel tipo = new TipoImovel(tipoInput.getText());
                if(tiposImoveis.contains(tipo) == false){
                    tiposImoveis.add(tipo);
                }

                Endereco enderecoProp = new Endereco(ruaProp, numeroP, bairroProp, cidadeProp, CEPProp);

                String cpfProp = cpfPropInput.getText();
                String rgProp = rgPropInput.getText();
                String celularProp = celularPropInput.getText();
                String dataProp = dataPropInput.getText();
                String pix = pixInput.getText();
                String nomePro = nomeProInput.getText();
                // Creating a Proprietario (property owner) object

                Proprietario proprietario = new Proprietario(nomePro, cpfProp, rgProp, enderecoProp, celularProp, dataProp, pix);
                
                // Adding the property owner to the list if not already present
                if (!proprietarios.contains(proprietario)) {
                    proprietarios.add(proprietario);
                } 

                Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);

                String nomeCliente = nomeInput.getText();
                String cpfCliente = cpfInput.getText();
                String rgCliente = rgInput.getText();
                Endereco enderecoCliente = endereco; // Assuming 'endereco' is an existing Endereco object
                String celularCliente = celularInput.getText();
                String dataCliente = dataInput.getText();

                // Creating a Cliente (customer) object
                Cliente cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, enderecoCliente, celularCliente, dataCliente, pontuacao);

                // Adding the customer to the list if not already present
                if (!clientes.contains(cliente)) {
                    clientes.add(cliente);
                }
                
                Endereco enderecoCorre = new Endereco(ruaCo, numeroC, bairroCo, cidadeCo, CEPCo);

                String nomeCorretor = nomeCorreInput.getText();
                String cpfCorretor = cpfCorreInput.getText();
                String rgCorretor = rgCorreInput.getText();
                Endereco enderecoCorretor = enderecoCorre; // Assuming 'enderecoCorre' is an existing Endereco object
                String celularCorretor = celularCorreInput.getText();
                String dataCorretor = dataCorreInput.getText();
                String creciCorretor = creciInput.getText();
                
                // Creating a Corretor (broker) object
                Corretor corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, enderecoCorretor, celularCorretor, dataCorretor, creciCorretor);
                
                // Adding the broker to the list if not already present
                if (!corretores.contains(corretor)) {
                    corretores.add(corretor);
                }
                
                String tempo = tempoInput.getText();
                String razao = razaoInput.getText();
                String cpnj = cpnjInput.getText();

                Endereco enderecoImo = new Endereco(ruaImo, numeroI, bairroImo, cidadeImo, CEPImo);
            
                    Imovel imovel = new Imovel(tipo, enderecoImo, area, preco, proprietario);
                    if(sitInput.getText().equals("DISPONÍVEL")){
                        if(imoveisDisp.contains(imovel) == false){
                            imoveisDisp.add(imovel);
                        }
                    } else {
                        if(imoveisManu.contains(imovel) == false){
                            imoveisManu.add(imovel);
                        }   
                    }

                ContratoAluguelComercial contrato = new ContratoAluguelComercial(imovel, corretor, cliente, tempo, valor, razao, cpnj);
                
                // Adding the commercial contract to the list
                contratosComerciais.add(contrato);
                    
                    

        }  catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            
        });

    }

    public void cadastrarContrato(Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<ContratoAluguel<String>> contratosAlugueis, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){

        Text situacaoText = new Text("Situação do imóvel: insira 'EM MANUTENÇÃO' ou 'DISPONÍVEL");
        situacaoText.getStyleClass().add("text");
        TextField sitInput = new TextField();



        Text tittle = new Text("Contrato Aluguel");
        tittle.getStyleClass().add("tittle");

        Text imovelTittle = new Text("INFORMAÇÕES DO IMÓVEL");
        imovelTittle.getStyleClass().add("text");
            Text tipoText = new Text("Tipo de Imóvel: ");
            tipoText.getStyleClass().add("text");
            TextField tipoInput = new TextField();

            Text enderecoImoTitle = new Text("ENDEREÇO DO IMÓVEL");
            enderecoImoTitle.getStyleClass().add("text");
                Text RuaImoText = new Text("Rua: ");
                RuaImoText.getStyleClass().add("text");
                TextField ruaImoInput = new TextField();

                Text NumeroImoText = new Text("Numero: ");
                NumeroImoText.getStyleClass().add("text");
                TextField numeroImoInput = new TextField();

                Text BairroImoText = new Text("Bairro: ");
                BairroImoText.getStyleClass().add("text");
                TextField bairroImoInput = new TextField();

                Text CidadeImoText = new Text("Cidade: ");
                CidadeImoText.getStyleClass().add("text");
                TextField cidadeImoInput = new TextField();

                Text CEPImoText = new Text("CEP: ");
                CEPImoText.getStyleClass().add("text");
                TextField CEPImoInput = new TextField();

            Text areaText = new Text("Área: ");
            areaText.getStyleClass().add("text");
            TextField areaInput = new TextField();

            Text precoText = new Text("Preço: ");
            precoText.getStyleClass().add("text");
            TextField precoInput = new TextField();

        Text corretorTitle = new Text("INFORMAÇÕES DO CORRETOR");
        corretorTitle.getStyleClass().add("text");
            Text nomeCorreText = new Text("Nome: ");
            nomeCorreText.getStyleClass().add("text");
            TextField nomeCorreInput = new TextField();

            Text cpfCorreText = new Text("CPF: ");
            cpfCorreText.getStyleClass().add("text");
            TextField cpfCorreInput = new TextField();

            Text rgCorreText = new Text("RG: ");
            rgCorreText.getStyleClass().add("text");
            TextField rgCorreInput = new TextField();

            Text enderecoCorreTittle = new Text("ENDEREÇO DO CORRETOR");
            enderecoCorreTittle.getStyleClass().add("text");
                Text RuaCorreText = new Text("Rua: ");
                RuaCorreText.getStyleClass().add("text");
                TextField ruaCorreInput = new TextField();

                Text NumeroCorreText = new Text("Numero: ");
                NumeroCorreText.getStyleClass().add("text");
                TextField numeroCorreInput = new TextField();

                Text BairroCorreText = new Text("Bairro: ");
                BairroCorreText.getStyleClass().add("text");
                TextField bairroCorreInput = new TextField();

                Text CidadeCorreText = new Text("Cidade: ");
                CidadeCorreText.getStyleClass().add("text");
                TextField cidadeCorreInput = new TextField();

                Text CEPCorreText = new Text("CEP: ");
                CEPCorreText.getStyleClass().add("text");
                TextField CEPCorreInput = new TextField();

            Text celularCorreText = new Text("Celular: ");
            celularCorreText.getStyleClass().add("text");
            TextField celularCorreInput = new TextField();

            Text dataCorreText = new Text("Data de nascimento: ");
            dataCorreText.getStyleClass().add("text");
            TextField dataCorreInput = new TextField();

            Text creciText = new Text("Creci: ");
            creciText.getStyleClass().add("text");
            TextField creciInput = new TextField();

        Text proprietarioTitle = new Text("INFORMAÇÕES DO PROPRIETÁRIO");
        proprietarioTitle.getStyleClass().add("text");
            Text nomePropText = new Text("Nome: ");
            nomePropText.getStyleClass().add("text");
            TextField nomeProInput = new TextField();

            Text cpfProText = new Text("CPF: ");
            cpfProText.getStyleClass().add("text");
            TextField cpfPropInput = new TextField();

            Text rgPropText = new Text("RG: ");
            rgPropText.getStyleClass().add("text");
            TextField rgPropInput = new TextField();

            Text enderecoPropTittle = new Text("ENDEREÇO DO PROPRIETÁRIO");
            enderecoPropTittle.getStyleClass().add("text");
                Text RuaPropText = new Text("Rua: ");
                RuaPropText.getStyleClass().add("text");
                TextField ruaPropInput = new TextField();

                Text NumeroPropText = new Text("Numero: ");
                NumeroPropText.getStyleClass().add("text");
                TextField numeroPropInput = new TextField();

                Text BairroPropText = new Text("Bairro: ");
                BairroPropText.getStyleClass().add("text");
                TextField bairroPropInput = new TextField();

                Text CidadePropText = new Text("Cidade: ");
                CidadePropText.getStyleClass().add("text");
                TextField cidadePropInput = new TextField();

                Text CEPPropText = new Text("CEP: ");
                CEPPropText.getStyleClass().add("text");
                TextField CEPPropInput = new TextField();

            Text celularPropText = new Text("Celular: ");
            celularPropText.getStyleClass().add("text");
            TextField celularPropInput = new TextField();

            Text dataPropText = new Text("Data de nascimento: ");
            dataPropText.getStyleClass().add("text");
            TextField dataPropInput = new TextField();

            Text pixText = new Text("Pix: ");
            pixText.getStyleClass().add("text");
            TextField pixInput = new TextField();


        Text clienteTitle = new Text("INFORMAÇÕES DO CLIENTE");
        clienteTitle.getStyleClass().add("text");
            Text nomeText = new Text("Nome: ");
            nomeText.getStyleClass().add("text");
            TextField nomeInput = new TextField();

            Text cpfText = new Text("CPF: ");
            cpfText.getStyleClass().add("text");
            TextField cpfInput = new TextField();

            Text rgText = new Text("RG: ");
            rgText.getStyleClass().add("text");
            TextField rgInput = new TextField();

            Text enderecoTittle = new Text("ENDEREÇO DO CLIENTE");
            enderecoTittle.getStyleClass().add("text");
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

            Text celularText = new Text("Celular: ");
            celularText.getStyleClass().add("text");
            TextField celularInput = new TextField();

            Text dataText = new Text("Data de nascimento: ");
            dataText.getStyleClass().add("text");
            TextField dataInput = new TextField();

            Text pontText = new Text("Pontuação: ");
            pixText.getStyleClass().add("text");
            TextField pontInput = new TextField();

        Text tempoText = new Text("Tempo: ");
        tempoText.getStyleClass().add("text");
        TextField tempoInput = new TextField();

        Text valorText = new Text("Valor: ");
        valorText.getStyleClass().add("text");
        TextField valorInput = new TextField(); 
            
        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
            tittle,
            tempoText,
            tempoInput,
            valorText,
            valorInput,
            imovelTittle,
                tipoText,
                tipoInput,
                enderecoImoTitle,
                    RuaImoText,
                    ruaImoInput,
                    NumeroImoText,
                    numeroImoInput,
                    BairroImoText,
                    bairroImoInput,
                    CidadeImoText,
                    cidadeImoInput,
                    CEPImoText,
                    CEPImoInput,
                    areaText,
                    areaInput,
                    precoText,
                    precoInput,
                    situacaoText,
                    sitInput,
            proprietarioTitle,
                nomePropText,
                nomeProInput,                
                cpfProText,
                cpfPropInput,
                rgPropText,
                rgPropInput,
                celularPropText,
                celularPropInput,
                dataPropText,
                dataPropInput,
                pixText,
                pixInput,
                enderecoPropTittle,
                    RuaPropText,
                    ruaPropInput,
                    NumeroPropText,
                    numeroPropInput,
                    BairroPropText,
                    bairroPropInput,
                    CidadePropText,
                    cidadePropInput,
                    CEPPropText,
                    CEPPropInput,
            clienteTitle,
                nomeText,
                nomeInput,                
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                celularText,
                celularInput,
                dataText,
                dataInput,
                pontText,
                pontInput,
                enderecoTittle,
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
            corretorTitle,
                nomeCorreText,
                nomeCorreInput,                
                cpfCorreText,
                cpfCorreInput,
                rgCorreText,
                rgCorreInput,
                celularCorreText,
                celularCorreInput,
                dataCorreText,
                dataCorreInput,
                creciText,
                creciInput,
                enderecoCorreTittle,
                    RuaCorreText,
                    ruaCorreInput,
                    NumeroCorreText,
                    numeroCorreInput,
                    BairroCorreText,
                    bairroCorreInput,
                    CidadeCorreText,
                    cidadeCorreInput,
                    CEPCorreText,
                    CEPCorreInput,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();


        submitButton.setOnAction(event -> {

            try{
            
                String numImovel = numeroImoInput.getText();
                int numeroI = Integer.parseInt(numImovel);

                String areaStr = areaInput.getText();
                double area = Double.parseDouble(areaStr);

                String precoStr = precoInput.getText();
                double preco = Double.parseDouble(precoStr);

                String valorStr = valorInput.getText();
                double valor = Double.parseDouble(valorStr);
            
                String numCorre = numeroCorreInput.getText();
                int numeroC = Integer.parseInt(numCorre);
            
                String num = numeroInput.getText();
                int numero = Integer.parseInt(num);

                String numPro = numeroPropInput.getText();
                int numeroP = Integer.parseInt(numPro);

                String pont = pontInput.getText();
                int pontuacao = Integer.parseInt(pont);


                String ruaProp = ruaPropInput.getText();

                String bairroProp = bairroPropInput.getText();

                String cidadeProp = cidadePropInput.getText();

                String CEPProp = CEPPropInput.getText();

                
                String ruaImo = ruaImoInput.getText();

                String bairroImo = bairroImoInput.getText();

                String cidadeImo = cidadeImoInput.getText();

                String CEPImo = CEPImoInput.getText();

                
                String ruaCo = ruaCorreInput.getText();

                String bairroCo = bairroCorreInput.getText();

                String cidadeCo = cidadeCorreInput.getText();

                String CEPCo = CEPCorreInput.getText();


                String rua = ruaInput.getText();

                String bairro = bairroInput.getText();

                String cidade = cidadeInput.getText();

                String CEP = CEPInput.getText();


                TipoImovel tipo = new TipoImovel(tipoInput.getText());
                if(tiposImoveis.contains(tipo) == false){
                    tiposImoveis.add(tipo);
                }

                Endereco enderecoProp = new Endereco(ruaProp, numeroP, bairroProp, cidadeProp, CEPProp);

                String cpfProp = cpfPropInput.getText();
                String rgProp = rgPropInput.getText();
                String celularProp = celularPropInput.getText();
                String dataProp = dataPropInput.getText();
                String pix = pixInput.getText();
                String nomePro = nomeProInput.getText();
                // Creating a Proprietario (property owner) object

                Proprietario proprietario = new Proprietario(nomePro, cpfProp, rgProp, enderecoProp, celularProp, dataProp, pix);
                
                // Adding the property owner to the list if not already present
                if (!proprietarios.contains(proprietario)) {
                    proprietarios.add(proprietario);
                } 

                Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);

                String nomeCliente = nomeInput.getText();
                String cpfCliente = cpfInput.getText();
                String rgCliente = rgInput.getText();
                Endereco enderecoCliente = endereco; // Assuming 'endereco' is an existing Endereco object
                String celularCliente = celularInput.getText();
                String dataCliente = dataInput.getText();

                // Creating a Cliente (customer) object
                Cliente cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, enderecoCliente, celularCliente, dataCliente, pontuacao);

                // Adding the customer to the list if not already present
                if (!clientes.contains(cliente)) {
                    clientes.add(cliente);
                }
                
                Endereco enderecoCorre = new Endereco(ruaCo, numeroC, bairroCo, cidadeCo, CEPCo);

                String nomeCorretor = nomeCorreInput.getText();
                String cpfCorretor = cpfCorreInput.getText();
                String rgCorretor = rgCorreInput.getText();
                Endereco enderecoCorretor = enderecoCorre; // Assuming 'enderecoCorre' is an existing Endereco object
                String celularCorretor = celularCorreInput.getText();
                String dataCorretor = dataCorreInput.getText();
                String creciCorretor = creciInput.getText();
                
                // Creating a Corretor (broker) object
                Corretor corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, enderecoCorretor, celularCorretor, dataCorretor, creciCorretor);
                
                // Adding the broker to the list if not already present
                if (!corretores.contains(corretor)) {
                    corretores.add(corretor);
                }
                
                String tempo = tempoInput.getText();

                Endereco enderecoImo = new Endereco(ruaImo, numeroI, bairroImo, cidadeImo, CEPImo);
            
                    Imovel imovel = new Imovel(tipo, enderecoImo, area, preco, proprietario);
                    if(sitInput.getText().equals("DISPONÍVEL")){
                        if(imoveisDisp.contains(imovel) == false){
                            imoveisDisp.add(imovel);
                        }
                    } else {
                        if(imoveisManu.contains(imovel) == false){
                            imoveisManu.add(imovel);
                        }   
                    }

                ContratoAluguel<String> contrato = new ContratoAluguel<String>(imovel, corretor, cliente, tempo, valor);

                
                // Adding the commercial contract to the list
                contratosAlugueis.add(contrato);
                    
                    

        }  catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAlugueis, imoveisDisp, imoveisManu, tiposImoveis);
            
        });

    }

    @Override
    public void start(Stage primaryStage) {
        ArrayList<TipoImovel> tiposImoveis = new ArrayList<TipoImovel>();
        ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Corretor> corretores = new ArrayList<Corretor>();
        ArrayList<ContratoAluguel<String>> contratosAluguel = new ArrayList<>();
        ArrayList<ContratoAluguelComercial> contratosComerciais = new ArrayList<>();
        ArrayList<Imovel> imoveisDisp = new ArrayList<Imovel>();
        ArrayList<Imovel> imoveisManu = new ArrayList<Imovel>();
        tiposImoveis.add(new TipoImovel("Casa"));
        tiposImoveis.add(new TipoImovel("Sobrado"));
        tiposImoveis.add(new TipoImovel("Apartamento"));
        tiposImoveis.add(new TipoImovel("Muquifo"));
        tiposImoveis.add(new TipoImovel("Escritorio"));
        tiposImoveis.add(new TipoImovel("Tenda"));

        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, contratosAluguel, imoveisDisp, imoveisManu, tiposImoveis);
    }
}