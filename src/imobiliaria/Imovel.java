package imobiliaria;

public class Imovel implements Comparable<Imovel> {

    private TipoImovel tipo;
    private Endereco endereco;
    private double area;
    private double preco;
    private Proprietario proprietario;
    
    public Imovel(TipoImovel tipo, Endereco endereco, double area, double preco, Proprietario proprietario) {
        this.tipo = tipo;
        this.endereco = endereco;
        this.area = area;
        this.preco = preco;
        this.proprietario = proprietario;
    }

    @Override
    public int compareTo(Imovel o) {
        // TODO Auto-generated method stub
        return this.tipo.compareTo(o.tipo.getTipo());
    }
    

    
}
