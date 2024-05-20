
package Model;


public class Bitcoin extends Moeda implements Tarifa{
    
    public Bitcoin(String nome, double preco) {
        super(nome, preco);
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
