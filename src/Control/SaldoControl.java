
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import javax.swing.JOptionPane;
import View.Consulta;
import java.sql.Connection;
import java.sql.SQLException;


public class SaldoControl {
    private Consulta view;

    public SaldoControl(Consulta view) {
        this.view = view;
    }
    
    public void saldo(Investidor investidor, int id) throws SQLException{
        String senha = view.getTxtsenha().getText();
        String isenha = investidor.getCPF();
        if(senha.equals(isenha)){
           Conexaop2 conexao = new Conexaop2();
           Connection conn = conexao.getConnection();
           UsuarioDAO dao = new UsuarioDAO(conn);
           dao.att(investidor,id);
            view.getjTextArea1().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getSenha()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
  
        }
              
    }
}
