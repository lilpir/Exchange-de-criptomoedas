
package Control;
import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Bitcoin;
import Model.Carteira;
import Model.Ethereum;
import Model.Investidor;
import Model.Real;
import Model.Ripple;
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
                String Senha = res.getString("senha");
                double qtd_real = res.getDouble("qtereal");
                double qtd_bit = res.getDouble("qtebit");
                double qtd_rip = res.getDouble("qteri");
                double qtd_et = res.getDouble("qteet");
                
                Carteira carteira = new Carteira();
                
                int id = res.getInt("id");
                
                carteira.adicionar(new Real("Real",qtd_real,1,1));
                carteira.adicionar(new Bitcoin("Bitcoin",qtd_bit,355102.38,0.0000028));
                carteira.adicionar(new Ripple("Ripple",qtd_rip,2.74,0.37));
                carteira.adicionar(new Ethereum("Ethereum",qtd_et,18976.20,0.0052));    
                
                Investidor investidor = new Investidor(Nome,Usuario,CPF,Senha,carteira);
                
                PaginaInicial viewUsuario = new PaginaInicial(investidor, id);
                viewUsuario.setVisible(true);
                view.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(view,"Login nao foi efetuado!"); 
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    }
}