package imobiliaria;

public class Cliente extends Pessoa {
    private int pontuacao;

    public Cliente(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, int pontuacao) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Cliente " + super.getNome() + "[pontuacao = " + pontuacao + "]";
    }
    
}