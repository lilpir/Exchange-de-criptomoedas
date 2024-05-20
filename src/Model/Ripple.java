
package Model;


public class Ripple extends Moeda implements Tarifa{
    
    public Ripple(String nome, double preco) {
        super(nome, preco);
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
