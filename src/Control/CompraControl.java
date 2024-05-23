/**
 * Classe responsável por controlar a funcionalidade de compra de moedas.
 * Autor: Alexandre Domiciano Pierri
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Compra;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Controla a funcionalidade de compra de moedas.
 */
public class CompraControl {
    private Compra view;
    
    double pagar = 0;
    
    /**
     * Construtor da classe CompraControl.
     * @param view A view de compra associada a este controlador.
     */
    public CompraControl(Compra view) {
        this.view = view;
    }
    
    /**
     * Realiza uma compra de moedas.
     * @param investidor O investidor que realiza a compra.
     * @param id O identificador do investidor no banco de dados.
     */
    public void Compra(Investidor investidor, int id){
        String op = view.getjTextFieldTipo().getText();
        String qte = view.getjTextFieldTipo1().getText();
        double qte2 = Double.parseDouble(qte);
        if(op.equals("1")){
             pagar = 1.02* qte2 *investidor.getCarteira().getMoeda().get(1).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                double total = investidor.getCarteira().getMoeda().get(1).getqte()+qte2;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(1).setqte(total);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                double pos2 = pagar -investidor.getCarteira().getMoeda().get(0).getqte();
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta R$"+pos2);
            }
            
        }
        
        else if(op.equals("2")){
             pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(2).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                double total = investidor.getCarteira().getMoeda().get(2).getqte()+qte2;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(2).setqte(total);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                double pos2 = pagar -investidor.getCarteira().getMoeda().get(0).getqte();
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta R$"+pos2);
            }
            
        }
        
        else if(op.equals("3")){
             pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(3).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                double total = investidor.getCarteira().getMoeda().get(3).getqte()+qte2;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(3).setqte(total);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
                
            }
            else{
                double pos2 = pagar -investidor.getCarteira().getMoeda().get(0).getqte();
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta R$"+pos2);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(view,"Digite 1,2 ou 3!");
        }
        
        Conexaop2 conexao = new Conexaop2();
        try{
            // Conecta ao banco de dados
            Connection conn = conexao.getConnection();
            // Cria um objeto DAO para manipular usuários no banco de dados
            UsuarioDAO dao = new UsuarioDAO(conn);
            // Atualiza as informações do investidor no banco de dados
            dao.att(investidor,id);
        }catch(SQLException e){
           JOptionPane.showMessageDialog(view,"Saldo nao atualizado!"); 
        }
    }
}
