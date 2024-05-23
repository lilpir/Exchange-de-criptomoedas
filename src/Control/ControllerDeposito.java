/**
 * Classe responsável por controlar a funcionalidade de depósito na carteira do investidor.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Deposito;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Controla a funcionalidade de depósito na carteira do investidor.
 */
public class ControllerDeposito {
    private Deposito view;
    
    /**
     * Construtor da classe ControllerDeposito.
     * @param view A view de depósito associada a este controlador.
     */
    public ControllerDeposito(Deposito view){
        this.view = view;
    }
    
    /**
     * Realiza um depósito na carteira do investidor.
     * @param investidor O investidor cuja carteira será atualizada.
     * @param id O identificador do investidor no banco de dados.
     */
    public void deposito(Investidor investidor, int id){
        // Exibe informações do investidor antes do depósito na view
        view.getjTextAreaAntes().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
        
        // Obtém o saldo atual de Real na carteira do investidor
        double pre =  investidor.getCarteira().getMoeda().get(0).getqte();       
        // Obtém o valor do depósito informado pelo usuário
        String dep = view.getjTextFieldQte().getText();
        Conexaop2 conexao = new Conexaop2();
        double depFloat = Double.parseDouble(dep);
        double total = depFloat + pre;

        // Atualiza o saldo de Real na carteira do investidor com o novo total
        investidor.getCarteira().getMoeda().get(0).setqte(total);
           
        // Exibe informações do investidor após o depósito na view
        view.getjTextAreaDepois().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
        try{
            // Conecta ao banco de dados
            Connection conn = conexao.getConnection();
            // Cria um objeto DAO para manipular usuários no banco de dados
            UsuarioDAO dao = new UsuarioDAO(conn);
            // Atualiza as informações do investidor no banco de dados
            dao.att(investidor,id);
           
       } catch(SQLException e){
           // Exibe uma mensagem de erro se ocorrer uma exceção SQL
           System.out.println(e);
           JOptionPane.showMessageDialog(view,"Digite um número!"); 
       }
        
    }
}
