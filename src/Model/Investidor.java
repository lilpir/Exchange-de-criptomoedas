
package Model;

public class Investidor extends Usuario{
    private Carteira carteira;
    public Investidor(String nome, String usuario, String senha, String CPF, Carteira carteira) {
        super(nome,usuario,senha,CPF);
        this.carteira = carteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Investidor(Carteira carteira) {
        this.carteira = carteira;
    }
    
    
}
