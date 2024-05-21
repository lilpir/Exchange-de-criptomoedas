
package Model;

/**
 *
 * @author unifapierri
 */
public class Real extends Moeda {

    public Real(String nome, double preco) {
        super(nome, preco);
    }
    
    
    @Override
    public double compra( double preco){
        return preco;
    }
    
    @Override
    public double venda( double preco){
        return preco;
    }
}
