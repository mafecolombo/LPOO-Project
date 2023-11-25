package imobiliaria;

public class Proprietario extends Pessoa {
    private String pix;

    public Proprietario(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, String pix) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        this.pix = pix;
    }

    @Override
    public String toString() {
        return "Proprietario " + super.getNome() + "[pix = " + pix + "]";
    }
    
}
