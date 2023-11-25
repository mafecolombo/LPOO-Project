package imobiliaria;

public class Cliente extends Pessoa {
    private int pontuacao;

    public Cliente(String nome, String cpf, 
    Endereco endereco, String celular, int pontuacao) {
        super(nome, cpf, endereco, celular);
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Cliente " + super.getNome() + " Pontuação: " + pontuacao;
    }
    
}