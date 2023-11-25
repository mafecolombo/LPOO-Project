package imobiliaria;

public class Corretor extends Pessoa {
    private String creci;

    public Corretor(String nome, String cpf, 
    Endereco endereco, String celular, String creci) {
        super(nome, cpf, endereco, celular);
        this.creci = creci;
    }

    @Override
    public String toString() {
        return "Corretor " + super.getNome() + "[creci = " + creci + "]";
    }
    
}
