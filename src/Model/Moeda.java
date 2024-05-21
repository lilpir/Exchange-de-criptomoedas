
package Model;


public abstract class Moeda implements Tarifa{

    private String nome;
    protected double qte;
    protected double cot;
    public Moeda(String nome, double qte, double cot){
        this.nome = nome;
        this.qte = qte;
        this.cot = cot;
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
    
    

    @Override
    public abstract double compra(double valor);

    @Override
    public abstract double venda(double valor);


    
    
    
}
