package imobiliaria;

import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
			this.cpf = cpf;
			solicitarNovo();
		}
		
		
	}
	
	@Override
	public boolean validar(String cpf) {
		//https://www.campuscode.com.br/conteudos/o-calculo-do-digito-verificador-do-cpf-e-do-cnpj

		int digitoCPF[] = new int[11];
		
		int n = cpf.length();

		if (n == 11){
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

		} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Tela de Erro");
				alert.setHeaderText("Ocorreu um erro!");
				alert.setContentText("CPF invalido");
				alert.showAndWait();
				return false;
		}
	}

	 @Override
	public void solicitarNovo() {

		String cpf = getCpf();
        TextInputDialog novoCPF = new TextInputDialog();
        novoCPF.setTitle("Inserir Novo CPF");
        novoCPF.setHeaderText("Por favor, insira CPF " + cpf + " novamente.");
        novoCPF.setContentText("CPF (somente números):");
		novoCPF.showAndWait();

        // Mostrando o diálogo e aguardando a entrada do usuário
        // O valor retornado será null se o usuário pressionar Cancela
		
		if (validar(novoCPF.getResult()) == true) {
			this.cpf = novoCPF.getResult();
		} else {
			this.cpf = cpf;
			solicitarNovo();
		}
		 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	 
}
