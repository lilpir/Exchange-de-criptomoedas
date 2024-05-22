
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
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta dinheiro");
            }
            
        }
        
        else if(op.equals("2")){
            double pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(2).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta dinheiro");
            }
            
        }
        
        else if(op.equals("3")){
            double pagar = 1.01* qte2 *investidor.getCarteira().getMoeda().get(3).getCot();
            double pos = investidor.getCarteira().getMoeda().get(0).getqte() - pagar;
            if(pos >=0){
                investidor.getCarteira().getMoeda().get(0).setqte(pos);
                JOptionPane.showMessageDialog(view,"Compra realizada com sucesso");
                JOptionPane.showMessageDialog(view,"Saldo atual: "+ pos);
            }
            else{
                JOptionPane.showMessageDialog(view,"Compra não realizada! Falta dinheiro");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(view,"Compra não realizada! Falta dinheiro");
        }
    }
}
