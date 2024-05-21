
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import View.Consulta;
import View.PaginaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class SaldoControl {
    private PaginaInicial view;

    public SaldoControl(PaginaInicial view) {
        this.view = view;
    }
    
    public Void saldo(){
        Conexaop2 conexao = new Conexaop2();
        try{
            Connection conn = conexao.getConnection();
            Consulta viewUsuario = new Consulta();
            viewUsuario.setVisible(true);
           
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        return null;
    }
}
