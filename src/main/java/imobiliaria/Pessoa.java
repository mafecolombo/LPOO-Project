package imobiliaria;

import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Pessoa implements Verificavel {
	private String nome; 
	private String cpf; 
	private String rg; 
	private Endereco endereco; 
	private String celular; 
	private String dataNascimento;

	public Pessoa(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento) {
		this.nome = nome;   
		this.endereco = endereco; 
		this.celular = celular; 
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		
		if (validar(cpf) == true) {
			this.cpf = cpf;
		} else {
			solicitarNovo();
		}
		
		
	}
	
	@Override
	public boolean validar(String cpf) {
		//https://www.campuscode.com.br/conteudos/o-calculo-do-digito-verificador-do-cpf-e-do-cnpj

		int digitoCPF[] = new int[11];
		
		for (int i = 0; i < 11; i++) {
			digitoCPF[i] = Character.getNumericValue(cpf.charAt(i));
		}


		int soma = 0;
		int cont = 10;
		int valor;
		for (int i = 0; i < 9; i++){
			valor = digitoCPF[i]*cont;
			soma = soma + valor;
			cont = cont - 1;
		}

		int resto = soma % 11;

		int primeiroVerif = 11 - resto;

		if(primeiroVerif >= 10){
			primeiroVerif = 0;
		}

		if(primeiroVerif != digitoCPF[10]){
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Tela de Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("CPF invalido");
    
            alert.showAndWait();
			return false;
		}


		soma = 0;
		cont = 11;
		valor = 0;
		for (int i = 0; i < 9; i++){
			valor = digitoCPF[i]*cont;
			soma = soma + valor;
			cont = cont - 1;
		}

		resto = soma % 11;

		int segundoVerif = 11 - resto;

		if(segundoVerif >= 10){
			segundoVerif = 0;
		}

		if(segundoVerif != digitoCPF[11]){
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Tela de Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("CPF invalido");
    
            alert.showAndWait();
			return false;
		}

		return true;

	}

	 @Override
	public void solicitarNovo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("\nCPF inválido. Por favor, digite-o novamente: ");
		String novoCPF = sc.next();
		
		if (validar(novoCPF) == true) {
			this.cpf = novoCPF;
		} else {
			solicitarNovo();
		}
		 
	}

	public String getNome() {
		return nome;
	}
	 
	 
}
