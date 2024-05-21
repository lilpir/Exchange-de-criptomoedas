/*

 */
package Control;
import Model.Carteira;
import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Bitcoin;
import Model.Ethereum;
import Model.Investidor;
import Model.Real;
import Model.Ripple;
import Model.Usuario;
import View.Cadastro;
import View.Login;
import View.PaginaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroControl {
    private Cadastro view;

    public CadastroControl(Cadastro view) {
        this.view = view;
    }
    
    public void salvarUser(){
        
        String nome = view.getjTextFieldNomeC().getText();
        String usuario = view.getjTextFieldUsuarioC().getText();
        String senha = view.getjTextFieldSenhaC().getText();
        String cpf = view.getjTextFieldCPFC().getText();
        
        Carteira carteira = new Carteira();
        
        carteira.adicionar(new Real("Real",0.0));
        carteira.adicionar(new Bitcoin("Bitcoin",0.0));
        carteira.adicionar(new Ripple("Ripple",0.0));
        carteira.adicionar(new Ethereum("Ethereum",0.0));        
        
        Investidor investidor = new Investidor(nome,usuario,cpf,senha,carteira);
        Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.cadastar(investidor);
            JOptionPane.showMessageDialog(view,"Usuario Cadastrado");
            
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(view,"Usuario nao Cadastrado");
        }
    }
}
