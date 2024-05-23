/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Venda;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class VendaControl {
     private Venda view;
     
     double recebe;

    public VendaControl(Venda view) {
        this.view = view;
    }
    public void Venda(Investidor investidor, int id){
        String op = view.getjTextFieldTipo().getText();
        String qte = view.getjTextFieldTipo1().getText();
        double qte2 = Double.parseDouble(qte);
        if(op.equals("1")){
            if(investidor.getCarteira().getMoeda().get(1).getqte() >= qte2 && qte2>0){
                 recebe = 0.97* qte2 *investidor.getCarteira().getMoeda().get(1).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(1).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(1).setqte(moedapos);
                JOptionPane.showMessageDialog(view,moedapos);
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuida!");
            }
            
        }
        else if(op.equals("2")){
            if(investidor.getCarteira().getMoeda().get(2).getqte() >= qte2 && qte2>0){
                 recebe = 0.99 * qte2 *investidor.getCarteira().getMoeda().get(2).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(2).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(2).setqte(moedapos);
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuida!");
            }
            
        }
        else if(op.equals("3")){
            if(investidor.getCarteira().getMoeda().get(3).getqte() >= qte2 && qte2>0){
                 recebe = 0.98 * qte2 *investidor.getCarteira().getMoeda().get(3).getCotvenda();
                double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                double moedapos = investidor.getCarteira().getMoeda().get(3).getqte() - qte2;
                investidor.getCarteira().getMoeda().get(3).setqte(moedapos);
                JOptionPane.showMessageDialog(view,"Venda realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Quantidade digitada maior que a quantidade possuida!");
            }
        }
        else{
            JOptionPane.showMessageDialog(view,"Digite 1 ou 2 ou 3");
        }
        
       Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.att(investidor,id);
            
            if(op.equals("1")){
                dao.adicionarExtrato(investidor, recebe, qte2*(-1), 0, 0, "Venda de cripto");
            }
            else if(op.equals("2")){
                dao.adicionarExtrato(investidor, recebe, 0, qte2*(-1), 0, "Venda de cripto");
            }
            else if(op.equals("3")){
                dao.adicionarExtrato(investidor, recebe, 0, 0, qte2*(-1), "Venda de cripto");
            }
           
        }catch(SQLException e){
           JOptionPane.showMessageDialog(view,"Saldo nao atualizado!"); 
        }
    }
}
