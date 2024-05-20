/*

 */
package Control;
import Model.Carteira;
import DAO.Conexaop2;
import DAO.UsuarioDAO;
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
    
    public void salvarAluno(){
        
        String nome = view.getjTextFieldNomeC().getText();
        String usuario = view.getjTextFieldUsuarioC().getText();
        String senha = view.getjTextFieldSenhaC().getText();
        String cpf = view.getjTextFieldCPFC().getText();
        
        Usuario user = new Usuario(nome,usuario,senha,cpf);
        
        Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.cadastar(user);
            JOptionPane.showMessageDialog(view,"Usuario Cadastrado");
            
       
            
            Carteira c = new  Carteira(0,0,0,0);
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(view,"Usuario nao Cadastrado");
        }
    }
}
