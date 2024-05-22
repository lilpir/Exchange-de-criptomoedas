
package Model;

/**
 *
 * @author unifapierri
 */
public class Real extends Moeda {

    public Real(String nome, double qte, double cot, double cotvenda) {
        super(nome, qte, cot, cotvenda);
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
