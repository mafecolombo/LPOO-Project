package imobiliaria;

public class ContratoAluguelComercial extends ContratoAluguel {
    
    private String razaoSocial;
    private String cnpj;
   
    public ContratoAluguelComercial(Imovel imovel, Corretor corretor, Cliente cliente, Object tempo, double valor,
            String razaoSocial, String cnpj) {
        super(imovel, corretor, cliente, tempo, valor);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    
    
}
