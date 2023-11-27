package imobiliaria;

public class Corretor extends Pessoa {
    private String creci;

    public Corretor(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, String creci) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        this.creci = creci;
    }

    @Override
    public String toString() {

        return "Cliente " + super.getNome() + 
        "[CPF = " + super.getCpf() + ", RG = " + super.getEndereco() + 
        ", celular = " + super.getCelular() + ", data de nascimento = " 
        + super.getDataNascimento() + ", creci = " + creci + "]";
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }
    
}
