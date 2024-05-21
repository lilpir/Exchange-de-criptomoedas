
package Model;

import java.util.ArrayList;

public class Carteira{
    private ArrayList<Moeda> coins = new ArrayList<>();

    public Carteira() {
    }
    
    public Carteira(ArrayList<Moeda> moeda){
        this.coins = moeda;
    }

    public ArrayList<Moeda> getMoeda() {
        return coins;
    }

    public void setMoeda(ArrayList<Moeda> moeda) {
        this.coins = moeda;
    }
    
    public void adicionar(Moeda moeda){
        coins.add(moeda);
    }
    
    
}
