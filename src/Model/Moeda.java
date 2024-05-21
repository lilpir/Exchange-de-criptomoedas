
package Model;


public abstract class Moeda implements Tarifa{

    private String nome;
    protected double preco;
    public Moeda(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    

    @Override
    public abstract double compra(double valor);

    @Override
    public abstract double venda(double valor);


    
    
    
}
