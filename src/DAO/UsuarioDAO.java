
package DAO;
import Model.Investidor;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class UsuarioDAO {
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet login(Usuario usuarios) throws SQLException{
//        String sql = "select * from aluno where usuario = '" +
//                    aluno.getUsuario() + "' AND senha = '" +
//                    aluno.getSenha() + "'";
        // Corrigindo o problema da injeção de sql;
        
        String sql = "select * from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuarios.getUsuario());
        statement.setString(2,usuarios.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void cadastar(Investidor usuarios) throws SQLException{
        String sql = "insert into usuario ( Usuario, Nome, CPF, Senha,qtereal,qtebit,qteri,qteet) values('"+
                    usuarios.getUsuario() + "', '"+
                    usuarios.getNome() + "', '"+
                    usuarios.getCPF() + "', '"+
                    usuarios.getSenha() + "', '"+
                    usuarios.getCarteira().getMoeda().get(0).getqte() + "', '"+
                    usuarios.getCarteira().getMoeda().get(1).getqte() + "', '"+
                    usuarios.getCarteira().getMoeda().get(2).getqte() + "', '"+
                    usuarios.getCarteira().getMoeda().get(3).getqte() + "')";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
   
}
