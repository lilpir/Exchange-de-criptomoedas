
package Model;


public class Bitcoin extends Moeda {
    
    public Bitcoin(String nome, double preco, double cot) {
        super(nome, preco,cot);
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
