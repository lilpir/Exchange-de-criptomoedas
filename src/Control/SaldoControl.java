/**
 * Classe responsável por controlar a funcionalidade de consulta de saldo do investidor.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import javax.swing.JOptionPane;
import View.Consulta;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Controla a funcionalidade de consulta de saldo do investidor.
 */
public class SaldoControl {
    private Consulta view;

    /**
     * Construtor da classe SaldoControl.
     * @param view A tela de consulta associada a este controlador.
     */
    public SaldoControl(Consulta view) {
        this.view = view;
    }
    
    /**
     * Verifica a senha do investidor e exibe o saldo se a senha estiver correta.
     * @param investidor O investidor cujo saldo será consultado.
     * @param id O identificador do investidor no banco de dados.
     * @throws SQLException Se ocorrer uma exceção SQL ao acessar o banco de dados.
     */
    public void saldo(Investidor investidor, int id) throws SQLException{
        // Obtém a senha digitada pelo usuário na tela de consulta
        String senha = view.getTxtsenha().getText();
        // Obtém a senha do investidor
        String isenha = investidor.getSenha();
        // Verifica se a senha digitada corresponde à senha do investidor
        if(senha.equals(isenha)){
            // Se a senha estiver correta, exibe o saldo na tela de consulta
            view.getjTextArea1().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
        }
    }
}
