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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void cadastrarPropritario(ArrayList<Proprietario> proprietarios, ArrayList<Endereco> enderecos, Stage primaryStage){

        Text nomeText = new Text("Nome: ");
        nomeText.getStyleClass().add("text");
        TextField nomeInput = new TextField();

        Text cpfText = new Text("CPF: ");
        cpfText.getStyleClass().add("text");
        TextField cpfInput = new TextField();

        Text rgText = new Text("RG: ");
        rgText.getStyleClass().add("text");
        TextField rgInput = new TextField();

        Text enderecoTitle = new Text("ENDEREÇO");
        enderecoTitle.getStyleClass().add("text");
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

        Text pixText = new Text("Pontuação: ");
        pixText.getStyleClass().add("text");
        TextField pixInput = new TextField();

        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            
            try{
            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);
            
            String nome = nomeInput.getText();

            String cpf = cpfInput.getText();

            String rg = rgInput.getText();

            String celular = celularInput.getText();

            String data = dataInput.getText();

            String pix = pixInput.getText();
                        
            proprietarios.add(new Proprietario(nome, cpf, rg, endereco, celular, data, pix));
            

        }catch(NumberFormatException e){
        
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
            
        });

        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
                nomeText,
                nomeInput,
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                enderecoTitle,
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
                celularText,
                celularInput,
                dataText,
                dataInput,
                pixText,
                pixInput,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void cadastrarCliente(List<Cliente> clientes, List<Endereco> enderecos, Stage primaryStage){

        Text nomeText = new Text("Nome: ");
        nomeText.getStyleClass().add("text");
        TextField nomeInput = new TextField();

        Text cpfText = new Text("CPF: ");
        cpfText.getStyleClass().add("text");
        TextField cpfInput = new TextField();

        Text rgText = new Text("RG: ");
        rgText.getStyleClass().add("text");
        TextField rgInput = new TextField();

        Text enderecoTitle = new Text("ENDEREÇO");
        enderecoTitle.getStyleClass().add("text");
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
        pontText.getStyleClass().add("text");
        TextField pontInput = new TextField();

        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            
            try{
            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);
            
            String nome = nomeInput.getText();

            String cpf = cpfInput.getText();

            String rg = rgInput.getText();

            String celular = celularInput.getText();

            String data = dataInput.getText();

            String pont = pontInput.getText();
            int pontuacao = Integer.parseInt(pont);    
            
            clientes.add(new Cliente(nome, cpf, rg, endereco, celular, data, pontuacao));
            
            
        }catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        start(primaryStage);
            
        });


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
                nomeText,
                nomeInput,
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                enderecoTitle,
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
                celularText,
                celularInput,
                dataText,
                dataInput,
                pontText,
                pontInput,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void cadastrarCorretor(List<Corretor> corretores, List<Endereco> enderecos, Stage primaryStage){

        Text nomeText = new Text("Nome: ");
        nomeText.getStyleClass().add("text");
        TextField nomeInput = new TextField();

        Text cpfText = new Text("CPF: ");
        cpfText.getStyleClass().add("text");
        TextField cpfInput = new TextField();

        Text rgText = new Text("RG: ");
        rgText.getStyleClass().add("text");
        TextField rgInput = new TextField();

        Text enderecoTitle = new Text("ENDEREÇO");
        enderecoTitle.getStyleClass().add("text");
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

        Text creciText = new Text("Creci: ");
        creciText.getStyleClass().add("text");
        TextField creciInput = new TextField();

        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {
            
            try{
            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);
            
            String nome = nomeInput.getText();

            String cpf = cpfInput.getText();

            String rg = rgInput.getText();

            String celular = celularInput.getText();

            String data = dataInput.getText();

            String creci = creciInput.getText();   
            
            corretores.add(new Corretor(nome, cpf, rg, endereco, celular, data, creci));
            
            
        }catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        start(primaryStage);
            
        });


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
                nomeText,
                nomeInput,
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                enderecoTitle,
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
                celularText,
                celularInput,
                dataText,
                dataInput,
                creciText,
                creciInput,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void cadastrarImoveis(ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis, ArrayList<Endereco> enderecos, ArrayList<Proprietario> proprietarios, Stage primaryStage){

            
        // Criar uma lista de itens para a caixa de seleção
        ObservableList<String> opcoes = FXCollections.observableArrayList(
                "Disponível",
                "Em manutenção"
        );

        // Criar uma caixa de seleção e definir suas opções
        Text selecText = new Text("Informe a situação do Imóvel: ");
        selecText.getStyleClass().add("text");
        ChoiceBox<String> caixaSelecao = new ChoiceBox<>(opcoes);


        Text tipoText = new Text("Tipo: ");
        tipoText.getStyleClass().add("text");
        TextField tipoInput = new TextField();

        Text enderecoTitle = new Text("ENDEREÇO");
        enderecoTitle.getStyleClass().add("text");
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

        Text areaText = new Text("Área: ");
        areaText.getStyleClass().add("text");
        TextField areaInput = new TextField();

        Text precoText = new Text("Data de nascimento: ");
        precoText.getStyleClass().add("text");
        TextField precoInput = new TextField();
        

        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");

        
        submitButton.setOnAction(event -> {
            int on = 1;

            while (on == 1) {

            try{
            String ttipo = tipoInput.getText();
            TipoImovel t = new TipoImovel(ttipo);
            if(tiposImoveis.contains(t) == false){
                tiposImoveis.add(t);
            }

            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);

            String a = areaInput.getText();
            double area = Double.parseDouble(a);

            String p = precoInput.getText();
            double preco = Double.parseDouble(p);

            cadastrarPropritario(proprietarios, enderecos, primaryStage);
            int ultimaPosicao = proprietarios.size() - 1;
            

                caixaSelecao.setOnAction(even -> {
                    // Obter a escolha selecionada e armazenar em uma variável
                    String escolha = caixaSelecao.getValue();
                    if(escolha.equals("Disponível") == true){
                        imoveisDisp.add(new Imovel(t, endereco, area, preco, proprietarios.get(ultimaPosicao)));
                    } else {
                        imoveisManu.add(new Imovel(t, endereco, area, preco, proprietarios.get(ultimaPosicao)));
                    }
                });

            on = 0;
     
            
        }catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
        start(primaryStage);
        }
    }start(primaryStage);});


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
            tipoText,
            tipoInput,
            enderecoTitle,
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
                areaText,
                areaInput,
                precoText,
                precoInput,
                caixaSelecao,
                selecText,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void cadastrarContratoa(List<Imovel> imoveisDisp, List<Imovel> imoveisManu, List<TipoImovel> tiposImoveis, List<Endereco> enderecos, List<Proprietario> proprietarios, List<Corretor> corretores, List<Cliente> clientes, Stage primaryStage){

        // Criar uma lista de itens para a caixa de seleção
        ObservableList<String> opcoes = FXCollections.observableArrayList(
                "Disponível",
                "Em manutenção"
        );

        Text tittle = new Text("Contrato Aluguel Comercial");
        tittle.getStyleClass().add("");

        // Criar uma caixa de seleção e definir suas opções
        Text selecText = new Text("Informe a situação do Imóvel: ");
        selecText.getStyleClass().add("text");
        ChoiceBox<String> caixaSelecao = new ChoiceBox<>(opcoes);

        Text tipoText = new Text("Nome: ");
        tipoText.getStyleClass().add("text");
        TextField tipoInput = new TextField();

        Text enderecoTitle = new Text("ENDEREÇO");
        enderecoTitle.getStyleClass().add("text");
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

        Text areaText = new Text("Área: ");
        areaText.getStyleClass().add("text");
        TextField areaInput = new TextField();

        Text precoText = new Text("Data de nascimento: ");
        precoText.getStyleClass().add("text");
        TextField precoInput = new TextField();


        Text propTittle = new Text("PROPRIETÁRIO");
        propTittle.getStyleClass().add("text");
            Text nomeText = new Text("Nome: ");
            nomeText.getStyleClass().add("text");
            TextField nomeInput = new TextField();

            Text cpfText = new Text("CPF: ");
            cpfText.getStyleClass().add("text");
            TextField cpfInput = new TextField();

            Text rgText = new Text("RG: ");
            rgText.getStyleClass().add("text");
            TextField rgInput = new TextField();

            Text endereco2Title = new Text("ENDEREÇO");
            enderecoTitle.getStyleClass().add("text");
                Text Rua2Text = new Text("Rua: ");
                RuaText.getStyleClass().add("text");
                TextField rua2Input = new TextField();

                Text Numero2Text = new Text("Numero: ");
                NumeroText.getStyleClass().add("text");
                TextField numero2Input = new TextField();

                Text Bairro2Text = new Text("Bairro: ");
                BairroText.getStyleClass().add("text");
                TextField bairro2Input = new TextField();

                Text Cidade2Text = new Text("Cidade: ");
                CidadeText.getStyleClass().add("text");
                TextField cidade2Input = new TextField();

                Text CEPText2 = new Text("CEP: ");
                CEPText.getStyleClass().add("text");
                TextField CEPInput2 = new TextField();

            Text celularText = new Text("Celular: ");
            celularText.getStyleClass().add("text");
            TextField celularInput = new TextField();

            Text dataText = new Text("Data de nascimento: ");
            dataText.getStyleClass().add("text");
            TextField dataInput = new TextField();

            Text pixText = new Text("Pontuação: ");
            pixText.getStyleClass().add("text");
            TextField pixInput = new TextField();
        

        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");

        submitButton.setOnAction(event -> {

            try{
            String tipo = tipoInput.getText();
            TipoImovel t = new TipoImovel(tipo);
            if(tiposImoveis.contains(tipo) == false){
                tiposImoveis.add(t);
            }

            String rua = ruaInput.getText();

            String num = numeroInput.getText();
            int numero = Integer.parseInt(num);

            String bairro = bairroInput.getText();

            String cidade = cidadeInput.getText();

            String CEP = CEPInput.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, CEP);

            String a = areaInput.getText();
            double area = Double.parseDouble(a);

            String p = precoInput.getText();
            double preco = Double.parseDouble(p);

                String rua02 = rua2Input.getText();

                String num02 = numero2Input.getText();
                int numero02 = Integer.parseInt(num02);

                String bairro02 = bairro2Input.getText();

                String cidade02 = cidade2Input.getText();

                String CEP02 = CEPInput2.getText();

                Endereco endereco02 = new Endereco(rua02, numero02, bairro02, cidade02, CEP02);
                
                String nome = nomeInput.getText();

                String cpf = cpfInput.getText();

                String rg = rgInput.getText();

                String celular = celularInput.getText();

                String data = dataInput.getText();

                String pix = pixInput.getText();   
                
                Proprietario proprietario = new Proprietario(nome, cpf, rg, endereco02, celular, data, pix);
                if(proprietarios.contains(proprietario) == false){
                    proprietarios.add(proprietario);
                }

                caixaSelecao.setOnAction(even -> {
                    // Obter a escolha selecionada e armazenar em uma variável
                    String escolha = caixaSelecao.getValue();
                    if(escolha.equals("Disponível") == true){
                        imoveisDisp.add(new Imovel(t, endereco, area, preco, proprietario));
                    } else {
                        imoveisManu.add(new Imovel(t, endereco, area, preco, proprietario));
                    }
                });
        

            
            
            
        }catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        start(primaryStage);
            
        });


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
            tipoText,
            tipoInput,
            enderecoTitle,
                nomeText,
                nomeInput,
                cpfText,
                cpfInput,
                rgText,
                rgInput,
                endereco2Title,
                Rua2Text,
                rua2Input,
                Numero2Text,
                numero2Input,
                Bairro2Text,
                bairro2Input,
                Cidade2Text,
                cidade2Input,
                CEPText2,
                CEPInput2,
                celularText,
                celularInput,
                dataText,
                dataInput,
                pixText,
                pixInput,
                caixaSelecao,
                selecText,
                submitButton
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(cadastrar);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("/estilo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Controle de Imóveis");
        ArrayList<TipoImovel> tiposImoveis = new ArrayList<TipoImovel>();
        ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Corretor> corretores = new ArrayList<Corretor>();
        ArrayList<ContratoAluguelComercial> contratosComerciais = new ArrayList<ContratoAluguelComercial>();
        ArrayList<Imovel> imoveisDisp = new ArrayList<Imovel>();
        ArrayList<Imovel> imoveisManu = new ArrayList<Imovel>();

        tiposImoveis.add(new TipoImovel("Casa"));
        tiposImoveis.add(new TipoImovel("Sobrado"));
        tiposImoveis.add(new TipoImovel("Apartamento"));
        tiposImoveis.add(new TipoImovel("Muquifo"));
        tiposImoveis.add(new TipoImovel("Escritorio"));
        tiposImoveis.add(new TipoImovel("Tenda"));

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
            cadastrarCliente(clientes, enderecos, primaryStage);
        });

        cadastrarCorretoresButton.setOnAction(event -> {
            cadastrarCorretor(corretores, enderecos, primaryStage);
        });


        cadastrarImoveisButton.setOnAction(event -> {
            cadastrarImoveis(imoveisDisp, imoveisManu, tiposImoveis, enderecos, proprietarios, primaryStage);
        });

    }

}
