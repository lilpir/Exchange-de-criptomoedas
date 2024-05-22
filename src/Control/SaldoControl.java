
package Control;

import Model.Investidor;
import javax.swing.JOptionPane;
import View.Consulta;


public class SaldoControl {
    private Consulta view;

    public SaldoControl(Consulta view) {
        this.view = view;
    }
    
    public void saldo(Investidor investidor, int id){
        String senha = view.getTxtsenha().getText();
        String isenha = investidor.getCPF();
        JOptionPane.showMessageDialog(view, isenha);
        if(senha.equals(isenha)){
            view.getjTextArea1().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
  
        }
              
    }
}
