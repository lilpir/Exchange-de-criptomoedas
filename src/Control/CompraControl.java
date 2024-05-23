
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Compra;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class CompraControl {
    private Compra view;
    
    double pagar = 0;
    
    
    public CompraControl(Compra view) {
        this.view = view;
    }
    
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
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.att(investidor,id);
            if(op.equals("1")){
                dao.adicionarExtrato(investidor, pagar*(-1), qte2, 0, 0, "Compra de cripto");
            }
            else if(op.equals("2")){
                dao.adicionarExtrato(investidor, pagar*(-1), 0, qte2, 0, "Compra de cripto");
            }
            else if(op.equals("3")){
                dao.adicionarExtrato(investidor, pagar*(-1), 0, 0, qte2, "Compra de cripto");
            }
           
        }catch(SQLException e){
           JOptionPane.showMessageDialog(view,"Saldo nao atualizado!"); 
        }
    }
}
