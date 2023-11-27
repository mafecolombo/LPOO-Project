package imobiliaria;

public class Proprietario extends Pessoa {
    private String pix;

    public Proprietario(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, String pix) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        this.pix = pix;
    }

    @Override
    public String toString() {

        return "Cliente " + super.getNome() + 
        "[CPF = " + super.getCpf() + ", RG = " + super.getEndereco() + 
        ", celular = " + super.getCelular() + ", data de nascimento = " 
        + super.getDataNascimento() + ", pix = " + pix + "]";
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}
