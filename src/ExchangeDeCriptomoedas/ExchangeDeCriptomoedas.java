package ExchangeDeCriptomoedas;

import View.Login;

/**
 * Esta classe é responsável por iniciar a aplicação de troca de criptomoedas.
 * Autor: Alexandre Domiciano Pierri
 */
public class ExchangeDeCriptomoedas {
    
    /**
     * Método principal que inicia a aplicação.
     * @param args Os argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Cria uma instância da tela de login
        Login l = new Login();
        // Torna a tela de login visível
        l.setVisible(true);
    }
    
}
