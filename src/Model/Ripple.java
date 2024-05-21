
package Model;


public class Ripple extends Moeda{
    
    public Ripple(String nome, double preco, double cot) {
        super(nome, preco,cot);
    }
    
    @Override
    public double compra( double preco){
        return preco * 1.01;
    }
    
    @Override
    public double venda( double preco){
        return preco * 0.99 ;
    }
}
