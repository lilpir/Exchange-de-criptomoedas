
package DAO;
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
        
        String sql = "select * from usuarios where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuarios.getUsuario());
        statement.setString(2,usuarios.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void cadastar(Usuario usuarios) throws SQLException{
        String sql = "insert into usuarios ( Usuario, Nome, CPF, Senha) values('"+
                    usuarios.getUsuario() + "', '"+
                    usuarios.getNome() + "', '"+
                    usuarios.getCPF() + "', '"+
                    usuarios.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void excluir(Usuario usuarios)throws SQLException{
        String sql = "delete from usuarios where usuario = ?";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1,usuarios.getUsuario());
         statement.execute();
         conn.close();
    }
    
    public void atualizar(Usuario usuarios)throws SQLException{
        String sql = "update usuarios set senha = ? where usuario = ?";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1,usuarios.getSenha());
         statement.setString(2,usuarios.getUsuario());
         statement.execute();
         conn.close();
    }
}
