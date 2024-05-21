
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Bitcoin;
import Model.Carteira;
import Model.Ethereum;
import Model.Investidor;
import Model.Real;
import Model.Ripple;
import View.Consulta;
import View.PaginaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            System.out.println("aqui");
            view.getjTextArea1().setText("Real: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
  
        }
              
    }
}
