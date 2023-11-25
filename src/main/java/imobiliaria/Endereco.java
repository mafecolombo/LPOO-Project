package imobiliaria;

public class Endereco {
	String rua; 
	int numero; 
	String bairro; 
	String cidade; 
	String cep;
	
	public Endereco(String rua, int numero, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	
	public Endereco(String rua, int numero, String bairro, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}
}