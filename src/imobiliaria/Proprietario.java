package imobiliaria;

public class Proprietario extends Pessoa {
    private String pix;

    public Proprietario(String nome, String cpf, 
    Endereco endereco, String celular, String pix) {
        super(nome, cpf, endereco, celular);
        this.pix = pix;
    }

    @Override
    public String toString() {
        return "Proprietario " + super.getNome() + "[pix = " + pix + "]";
    }
    
}
