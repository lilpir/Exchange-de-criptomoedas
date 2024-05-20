
package Model;


public class Ethereum  extends Moeda implements Tarifa{
    
    public Ethereum(String nome, double preco) {
        super(nome, preco);
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
