
package Model;

public interface Tarifa {
    public double venda( double valor);
    public double compra(double valor);
    
    void setcotcompra(double cotacao);
    void setcotvenda(double cotacao);
    
}
