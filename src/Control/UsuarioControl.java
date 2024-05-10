
package Control;
import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.PaginaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class UsuarioControl {
    private Login view;

    public UsuarioControl(Login view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Usuario pessoa = new Usuario(null, view.getjTextFieldUsuario().getText(), view.getjTextFieldSenha().getText(), null);
        Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.login(pessoa);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login feito!");
                String Nome = res.getString("nome");
                String Usuario = res.getString("usuario");
                String CPF = res.getString("cpf");
                String Senha = res.getString("Senha");
                PaginaInicial viewUsuario = new PaginaInicial();
                viewUsuario.setVisible(true);
                view.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(view,"Login nao foi efetuado!"); 
            }
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    }
}