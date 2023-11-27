package imobiliaria;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ContratoAluguelComercial extends ContratoAluguel<String> {

    
    private String razaoSocial;
    private String cnpj;
   
    public ContratoAluguelComercial(Imovel imovel, Corretor corretor, Cliente cliente, String tempo, double valor,
            String razaoSocial, String cnpj) {
        super(imovel, corretor, cliente, tempo, valor);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public boolean validarCNPJ(String cnpj) {
        if (!cnpj.matches("\\d{14}")) {Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("CNPJ Invalido");

        alert.showAndWait();
        return false;}

        int[] peso = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso[i + 1];
        }

        int remainder = soma % 11;
        if (remainder < 2 && cnpj.charAt(12) != '0'){ Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Tela de Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("CNPJ invalido");
    
            alert.showAndWait();
            return false;}

        if (remainder >= 2 && cnpj.charAt(12) != (char) ('0' + (11 - remainder))){ Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Tela de Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("CNPJ invalido");
    
            alert.showAndWait();
            return false;}

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso[i];
        }

        remainder = soma % 11;
        if (remainder < 2 && cnpj.charAt(13) != '0') {
             Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Tela de Erro");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText("CNPJ invalido");
        
        alert.showAndWait();
        return false;
        }
        if (remainder >= 2 && cnpj.charAt(13) != (char) ('0' + (11 - remainder))) { Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Tela de Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("CNPJ invalido");
    
            alert.showAndWait();
            return false;}

        return true;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    
}
