/**
 * Classe responsável por controlar a funcionalidade de saque na carteira do investidor.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Sacar;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Controla a funcionalidade de saque na carteira do investidor.
 */
public class ControllerSaque {
    private Sacar view;

    /**
     * Construtor da classe ControllerSaque.
     * @param view A view de saque associada a este controlador.
     */
    public ControllerSaque(Sacar view) {
        this.view = view;
    }

    /**
     * Realiza um saque na carteira do investidor.
     * @param investidor O investidor cuja carteira será atualizada.
     * @param id O identificador do investidor no banco de dados.
     */
    public void Saque(Investidor investidor, int id){
       // Exibe informações do investidor antes do saque na view
       view.getjTextAreaAntes().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
       double pre =  investidor.getCarteira().getMoeda().get(0).getqte();
       String dep = view.getjTextFieldQte().getText();
       Conexaop2 conexao = new Conexaop2();
       try{
           // Conecta ao banco de dados
           Connection conn = conexao.getConnection();
           // Cria um objeto DAO para manipular usuários no banco de dados
           UsuarioDAO dao = new UsuarioDAO(conn);
           double depFloat = Double.parseDouble(dep);
           double total = pre - depFloat;
           
           if(total >= 0){
                // Atualiza o saldo de Real na carteira do investidor com o novo total
                investidor.getCarteira().getMoeda().get(0).setqte(total);
                // Atualiza as informações do investidor no banco de dados
                dao.att(investidor,id);
                // Exibe informações do investidor após o saque na view
                view.getjTextAreaDepois().setText("Nome: "+ investidor.getNome()+
                     "\nCPF: "+ investidor.getCPF()+
                     "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                     "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                     "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                     "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
           }
           else{
               // Exibe uma mensagem de erro se o saque exceder o saldo disponível
               JOptionPane.showMessageDialog(view, dep + "R$ excede a quantia de dinheiro que você possui");
               JOptionPane.showMessageDialog(view, "Saque não concluído");
               // Atualiza as informações do investidor no banco de dados
               dao.att(investidor,id);
               // Exibe informações do investidor após o saque (não realizado) na view
               view.getjTextAreaDepois().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
           }
           
       } catch(SQLException  e){
           // Exibe uma mensagem de erro se ocorrer uma exceção SQL
           JOptionPane.showMessageDialog(view,"Digite um número!"); 
       }
    }
}
