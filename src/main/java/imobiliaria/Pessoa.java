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


		// First check digit
		int soma = 0;
		int cont = 10;
		for (int i = 0; i < 9; i++){
			soma += digitoCPF[i] * cont--;
		}

		int resto = soma % 11;
		int primeiroVerif = (resto < 2) ? 0 : 11 - resto;

		if(primeiroVerif != digitoCPF[9]){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Tela de Erro");
			alert.setHeaderText("Ocorreu um erro!");
			alert.setContentText("CPF invalido");
			alert.showAndWait();
			return false;
		}

		// Second check digit
		soma = 0;
		cont = 11;
		for (int i = 0; i < 10; i++){
			soma += digitoCPF[i] * cont--;
		}

		resto = soma % 11;
		int segundoVerif = (resto < 2) ? 0 : 11 - resto;

		if(segundoVerif != digitoCPF[10]){
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
