
package Model;


public abstract class Moeda implements Tarifa{

    private String nome;
    protected double qte;
    protected double cot;
    protected double cotvenda;
    public Moeda(String nome, double qte, double cot,double cotvenda){
        this.nome = nome;
        this.qte = qte;
        this.cot = cot;
        this.cotvenda = cotvenda;
    }

    public String getNome() {
        return nome;
    }

    public double getqte() {
        return qte;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setqte(double qte) {
        this.qte = qte;
    }

    public double getCot() {
        return cot;
    }

    public void setCot(double cot) {
        this.cot = cot;
    }

    public double getCotvenda() {
        return cotvenda;
    }

    public void setCotvenda(double cotvenda) {
        this.cotvenda = cotvenda;
    }
    
    
    

    @Override
    public abstract double compra(double valor);

    @Override
    public abstract double venda(double valor);

    @Override
    public void setcotcompra (double cotacao){
        this.cot = cotacao;
    }
    
    @Override
    public void setcotvenda (double cotacao){
        this.cotvenda = cotacao;}
    
    
}
