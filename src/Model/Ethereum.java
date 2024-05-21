
package Model;


public class Ethereum  extends Moeda {
    
    public Ethereum(String nome, double preco, double cot) {
        super(nome, preco,cot);
    }
    
    
    @Override
    public double compra( double preco){
        return preco *1.01;
    }
    
    
    @Override
    public double venda( double preco){
        return preco * 0.98 ;
    }
}
