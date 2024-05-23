
package Control;

import Model.Investidor;
import View.Compra;
import javax.swing.JOptionPane;


public class CompraControl {
    private Compra view;

    public CompraControl(Compra view) {
        this.view = view;
    }
    
    public void Compra(Investidor investidor, int id){
        String op = view.getjTextFieldTipo().getText();
        String qte = view.getjTextFieldTipo1().getText();
        double qte2 = Double.parseDouble(qte);
        if(op.equals("1")){
            double pagar = 1.02* qte2 *investidor.getCarteira().getMoeda().get(1).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(1).setqte(qte2);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                double pos2 = pagar -investidor.getCarteira().getMoeda().get(0).getqte();
                JOptionPane.showMessageDialog(view,pagar);
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta R$"+pos2);
            }
            
        }
        
        else if(op.equals("2")){
            double pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(2).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(2).setqte(qte2);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                double pos2 = pagar -investidor.getCarteira().getMoeda().get(0).getqte();
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta R$"+pos2);
            }
            
        }
        
        else if(op.equals("3")){
            double pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(3).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                investidor.getCarteira().getMoeda().get(3).setqte(qte2);
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
    }
}
