
package Model;


public abstract class Moeda implements Tarifa {

    private final String nome;
    private final int qtemoeda;
    private final double preco;
    private final double taxamoeda;
    public Moeda(String nome,int qtemoeda, double preco, double taxamoeda){
        this.nome = nome;
        this.qtemoeda = qtemoeda;
        this.preco = preco;
        this.taxamoeda = taxamoeda;
    }

    @Override
    public abstract double compra();

    @Override
    public abstract double venda();
    
}
