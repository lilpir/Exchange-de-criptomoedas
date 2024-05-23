/**
 * Classe responsável por controlar a interação entre a página inicial e outras funcionalidades.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import Model.Investidor;
import View.Login;
import View.PaginaInicial;
import View.Sacar;

/**
 * Controla a interação entre a página inicial e outras funcionalidades.
 */
public class PIcontrol {
    private PaginaInicial view;
    
    /**
     * Construtor da classe PIcontrol.
     * @param view A página inicial associada a este controlador.
     */
    public PIcontrol(PaginaInicial view){
        this.view = view;
    }
    
    /**
     * Abre a interface de saque para o investidor.
     * @param investidor O investidor que está realizando o saque.
     * @param id O identificador do investidor no banco de dados.
     */
    public void abre_saque(Investidor investidor, int id){
       // Cria uma nova instância da interface de saque
       Sacar sc = new Sacar(investidor, id);
       // Torna a interface de saque visível
       sc.setVisible(true);
    }
    
    /**
     * Sai da página inicial e volta para a tela de login.
     */
    public void sair(){
        // Torna a página inicial invisível
        view.setVisible(false);
        // Cria uma nova instância da tela de login
        Login login = new Login();
        // Torna a tela de login visível
        login.setVisible(true);
    }
}
