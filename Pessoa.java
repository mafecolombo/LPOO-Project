package imobiliaria;

import java.util.Scanner;

public abstract class Pessoa implements Verificavel {
	private String nome; 
	private String cpf; 
	private String rg; 
	private Endereco endereco; 
	private String celular; 
	private String dataNascimento;

	public Pessoa(String nome, String cpf, Endereco endereco, String celular) {
		this.nome = nome;   
		this.endereco = endereco; 
		this.celular = celular; 
		
		if (validar(cpf) == true) {
			this.cpf = cpf;
		} else {
			solicitarNovo();
		}
		
		
	}
	
	@Override
	public boolean validar(String cpf) {
		try {
            Integer.parseInt(cpf);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
