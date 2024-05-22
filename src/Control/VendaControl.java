/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Investidor;
import View.Venda;
import javax.swing.JOptionPane;


public class VendaControl {
     private Venda view;

    public VendaControl(Venda view) {
        this.view = view;
    }
    public void Venda(Investidor investidor, int id){
        String op = view.getjTextFieldTipo().getText();
        String qte = view.getjTextFieldTipo1().getText();
        double qte2 = Double.parseDouble(qte);
        if(op.equals("1") &&investidor.getCarteira().getMoeda().get(1).getqte() > qte2){
            double recebe = 0.97* qte2 *investidor.getCarteira().getMoeda().get(1).getCotvenda();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
            investidor.getCarteira().getMoeda().get(0).setqte(pos);
            JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
            JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            
        }
        else if(op.equals("2") &&investidor.getCarteira().getMoeda().get(2).getqte() > qte2){
            double recebe = 0.99 * qte2 *investidor.getCarteira().getMoeda().get(2).getCotvenda();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
            investidor.getCarteira().getMoeda().get(0).setqte(pos);
            JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
            JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            
        }
        else if(op.equals("3") &&investidor.getCarteira().getMoeda().get(3).getqte() > qte2){
            double recebe = 0.98 * qte2 *investidor.getCarteira().getMoeda().get(3).getCotvenda();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() + recebe;
            investidor.getCarteira().getMoeda().get(0).setqte(pos);
            JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
            JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            
        }
        else{
            JOptionPane.showMessageDialog(view,"Venda não realizada! Falta dinheiro");
        }
    }
}
