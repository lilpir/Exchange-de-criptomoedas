/**
 * Classe responsável por controlar a funcionalidade de venda de moedas.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Venda;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Controla a funcionalidade de venda de moedas.
 */
public class VendaControl {
     private Venda view;
     
     double recebe;

    /**
     * Construtor da classe VendaControl.
     * @param view A tela de venda associada a este controlador.
     */
    public VendaControl(Venda view) {
        this.view = view;
    }
    
    /**
     * Realiza a venda de moedas com base nas informações inseridas na tela de venda.
     * @param investidor O investidor que está realizando a venda.
     * @param id O ID do investidor.
     */
    public void Venda(Investidor investidor, int id){
        // Obtém o tipo de moeda e a quantidade inseridos na tela de venda
        String op = view.getjTextFieldTipo().getText();
        String qte = view.getjTextFieldTipo1().getText();
        double qte2 = Double.parseDouble(qte);
        // Verifica o tipo de moeda selecionado
        if(op.equals("1")){
            // Verifica se a quantidade de bitcoins é suficiente para a venda
            if(investidor.getCarteira().getMoeda().get(1).getqte() >= qte2 && qte2>0){
                 // Calcula o valor a ser recebido pela venda de bitcoins
                 recebe = 0.97* qte2 *investidor.getCarteira().getMoeda().get(1).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(1).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(1).setqte(moedapos);
                // Exibe mensagens de confirmação
                JOptionPane.showMessageDialog(view,moedapos);
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                // Exibe mensagem de erro se a quantidade digitada for maior que a quantidade possuída
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuída!");
            }
            
        }
        // Verifica se a venda é de Ripple
        else if(op.equals("2")){
            // Verifica se a quantidade de Ripples é suficiente para a venda
            if(investidor.getCarteira().getMoeda().get(2).getqte() >= qte2 && qte2>0){
                 // Calcula o valor a ser recebido pela venda de Ripples
                 recebe = 0.99 * qte2 *investidor.getCarteira().getMoeda().get(2).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(2).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(2).setqte(moedapos);
                // Exibe mensagens de confirmação
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                // Exibe mensagem de erro se a quantidade digitada for maior que a quantidade possuída
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuída!");
            }
            
        }
        // Verifica se a venda é de Ethereum
        else if(op.equals("3")){
            // Verifica se a quantidade de Ethereums é suficiente para a venda
            if(investidor.getCarteira().getMoeda().get(3).getqte() >= qte2 && qte2>0){
                 // Calcula o valor a ser recebido pela venda de Ethereums
                 recebe = 0.98 * qte2 *investidor.getCarteira().getMoeda().get(3).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(3).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(3).setqte(moedapos);
                // Exibe mensagens de confirmação
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                // Exibe mensagem de erro se a quantidade digitada for maior que a quantidade possuída
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuída!");
            }
        }
        else{
            // Exibe mensagem de erro se a opção selecionada não for válida
            JOptionPane.showMessageDialog(view,"Digite 1, 2 ou 3");
        }
        
       // Atualiza o saldo do investidor no banco de dados
       Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.att(investidor,id);
            
           
        }catch(SQLException e){
           // Exibe mensagem de erro se não for possível atualizar o saldo no banco de dados
           JOptionPane.showMessageDialog(view,"Saldo não atualizado!"); 
        }
    }
}
