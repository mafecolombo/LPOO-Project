package imobiliaria;

public class Corretor extends Pessoa {
    private String creci;

    public Corretor(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, String creci) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        this.creci = creci;
    }

    @Override
    public String toString() {
        return "Corretor " + super.getNome() + "[creci = " + creci + "]";
    }
    
}
