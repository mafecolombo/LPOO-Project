package imobiliaria;

public class TipoImovel {

    private String tipo;

    public TipoImovel(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

    public int compareTo(String tipo2) {
        return 0;
    }


    
}
