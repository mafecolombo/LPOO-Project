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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Main extends Application {

    public void menu(Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){
        Text tittleMenu = new Text("Bem-vindo ao Sistema de Controle de Imóveis");
        Text space01 = new Text("");
        Text space02 = new Text("");

        Button cadastrarContratosButton = new Button("Cadastrar Contrato");

        Button listarClientesButton = new Button("Listar Clientes");
        Button listarCorretoresButton = new Button("Listar Corretores");
        Button listarProprietariosButton = new Button("Listar Proprietarios");
        Button listarContratosButton = new Button("Listar Contratos");
        Button listarImoveisDisponiveisButton = new Button("Listar Imóveis Disponíveis");
        Button listarImoveisManutencaoButton = new Button("Listar Imóveis em Manutenção");

        // Aplicar estilos usando CSS
        cadastrarContratosButton.getStyleClass().add("button");

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
                cadastrarContratosButton
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

        cadastrarContratosButton.setOnAction(event -> {
            cadastrarContrato(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, imoveisDisp, imoveisManu, tiposImoveis);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cadastrarContrato(Stage primaryStage, ArrayList<Endereco> enderecos, ArrayList<Cliente> clientes, ArrayList<Corretor> corretores, ArrayList<Proprietario> proprietarios, ArrayList<ContratoAluguelComercial> contratosComerciais, ArrayList<Imovel> imoveisDisp, ArrayList<Imovel> imoveisManu, ArrayList<TipoImovel> tiposImoveis){

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

            ObservableList<String> opcoes = FXCollections.observableArrayList(
                "Disponível",
                "Em manutenção"
            );

            Text selecText = new Text("Informe a situação do Imóvel: ");
            selecText.getStyleClass().add("text");
            ChoiceBox<String> caixaSelecao = new ChoiceBox<>(opcoes);

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

            Text enderecoCorreTittle = new Text("ENDEREÇO");
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

            Text enderecoPropTittle = new Text("ENDEREÇO");
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

            Text pixText = new Text("Creci: ");
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

            Text enderecoTittle = new Text("ENDEREÇO");
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

            Text pontText = new Text("Creci: ");
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

        Text cpnjText = new Text("Razão social: ");
        cpnjText.getStyleClass().add("text");
        TextField cpnjInput = new TextField(); 
            
        Button submitButton = new Button("CADASTRAR");
        submitButton.getStyleClass().add("button");


        VBox cadastrar = new VBox(10);
        cadastrar.getChildren().addAll(
            tittle,
            tempoText,
            tempoInput,
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
                    selecText,
                    caixaSelecao,
            proprietarioTitle,
                nomePropText,
                nomeProInput,                
                cpfProText,
                cpfPropInput,
                rgPropText,
                rgPropInput,
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
                celularPropText,
                celularPropInput,
                dataPropText,
                dataPropInput,
                pixText,
                pixInput,
            clienteTitle,
                nomeText,
                nomeInput,                
                cpfText,
                cpfInput,
                rgText,
                rgInput,
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
                celularText,
                celularInput,
                dataText,
                dataInput,
                pontText,
                pontInput,
            corretorTitle,
                nomeCorreText,
                nomeCorreInput,                
                cpfCorreText,
                cpfCorreInput,
                rgCorreText,
                rgCorreInput,
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
                celularCorreText,
                celularCorreInput,
                dataCorreText,
                dataCorreInput,
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


        submitButton.setOnAction(event -> {

            try{
            
                String numImovel = numeroImoInput.getText();
                int numeroI = Integer.parseInt(numImovel);

                String areaStr = areaInput.getText();
                double area = Double.parseDouble(areaStr);

                String precoStr = precoInput.getText();
                double preco = Double.parseDouble(precoStr);
            
                String numCorre = numeroCorreInput.getText();
                int numeroC = Integer.parseInt(numCorre);
            
                String num = numeroInput.getText();
                int numero = Integer.parseInt(num);

                String numPro = numeroPropInput.getText();
                int numeroP = Integer.parseInt(numPro);

                String pont = pontInput.getText();
                int pontuacao = Integer.parseInt(pont);

                TipoImovel tipo = new TipoImovel(tipoInput.getText());
                if(tiposImoveis.contains(tipo) == false){
                    tiposImoveis.add(tipo);
                }

                Endereco enderecoProp = new Endereco(ruaPropInput.getText(), numeroP, bairroPropInput.getText(), cidadePropInput.getText(), CEPPropInput.getText());

                Proprietario proprietario = new Proprietario(nomeProInput.getText(), cpfPropInput.getText(), rgPropInput.getText(), enderecoProp, celularPropInput.getText(), dataPropInput.getText(), pixInput.getText());
                if(proprietarios.contains(proprietario) == false){
                    proprietarios.add(proprietario);
                }

                
                Endereco enderecoImo = new Endereco(ruaImoInput.getText(), numeroI, bairroImoInput.getText(), cidadeImoInput.getText(), CEPImoInput.getText());

                String escolha = caixaSelecao.getValue();
                Imovel imovel = new Imovel(tipo, enderecoImo, area, preco, proprietario);
                if(escolha.equals("Disponível")){
                    if(imoveisDisp.contains(imovel) == false){
                        imoveisDisp.add(imovel);
                    }
                } else{
                    if(imoveisManu.contains(imovel) == false){
                        imoveisManu.add(imovel);
                    }                    
                }

                Endereco endereco = new Endereco(ruaInput.getText(), numero, bairroInput.getText(), cidadeInput.getText(), CEPInput.getText());

                Cliente cliente = new Cliente(nomeInput.getText(), cpfInput.getText(), rgInput.getText(), endereco, celularInput.getText(), dataInput.getText(), pontuacao);
                if(clientes.contains(cliente) == false){
                    clientes.add(cliente);
                }
                
                Endereco enderecoCorre = new Endereco(ruaCorreInput.getText(), numeroC, bairroCorreInput.getText(), cidadeCorreInput.getText(), CEPCorreInput.getText());

                Corretor corretor = new Corretor(nomeCorreInput.getText(), cpfCorreInput.getText(), rgCorreInput.getText(), enderecoCorre, celularCorreInput.getText(), dataCorreInput.getText(), creciInput.getText());
                if(corretores.contains(corretor) == false){
                    corretores.add(corretor);
                }
            
        }  catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("Entrada inválida.");

        alert.showAndWait();
    

        }
        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, imoveisDisp, imoveisManu, tiposImoveis);
            
        });

    }

    @Override
    public void start(Stage primaryStage) {
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

        menu(primaryStage, enderecos, clientes, corretores, proprietarios, contratosComerciais, imoveisDisp, imoveisManu, tiposImoveis);
    }
}