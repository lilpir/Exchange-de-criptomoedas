
package Model;


public class Bitcoin extends Moeda {

    public Bitcoin(String nome, double qte, double cot, double cotvenda) {
        super(nome, qte, cot, cotvenda);
    }
    
    
    
    @Override
    public double compra( double preco){
        return preco *1.02;
    }
    
    @Override
    public double venda( double preco){
        return preco * 0.97 ;
    }
    

    
}
