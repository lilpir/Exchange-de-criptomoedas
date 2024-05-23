
package DAO;
import Model.Investidor;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import Model.Data;


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
        String sql = "insert into usuario ( Usuario, Nome, CPF, Senha,qtereal,qtebit,qteri,qteet) values(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuarios.getUsuario());
        statement.setString(2,usuarios.getNome());
        statement.setString(3,usuarios.getCPF());
        statement.setString(4,usuarios.getSenha());
        statement.setDouble(5, usuarios.getCarteira().getMoeda().get(0).getqte());
        statement.setDouble(6, usuarios.getCarteira().getMoeda().get(1).getqte());
        statement.setDouble(7, usuarios.getCarteira().getMoeda().get(2).getqte());
        statement.setDouble(8, usuarios.getCarteira().getMoeda().get(3).getqte());
        statement.execute();
        conn.close();
    }
    
    public void att(Investidor usuarios, int id) throws SQLException{
        String usuario = usuarios.getUsuario();
        String nome = usuarios.getNome();
        String cpf = usuarios.getCPF();
        String senha = usuarios.getSenha();
        double qtreal = usuarios.getCarteira().getMoeda().get(0).getqte();
        double qtbit = usuarios.getCarteira().getMoeda().get(1).getqte();
        double qtripp = usuarios.getCarteira().getMoeda().get(2).getqte();
        double qteth = usuarios.getCarteira().getMoeda().get(3).getqte();
        
        String sql = "UPDATE usuario Set Usuario = ?, Nome = ?, CPF = ?, Senha = ?,"+
                    "qtereal = ?, qtebit = ?, qteri = ?, qteet = ? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario);
        statement.setString(2,nome);
        statement.setString(3,cpf);
        statement.setString(4,senha);
        statement.setDouble(5,qtreal);
        statement.setDouble(6,qtbit);
        statement.setDouble(7,qtripp);
        statement.setDouble(8,qteth);
        statement.setInt(9,id);
        statement.executeUpdate();
    }
    
    public void adicionarExtrato(Investidor investidor , double valorReal 
            , double valorBitcoin , double valorEthereum , double valorRipple , String op) throws SQLException{
        String nome = investidor.getNome();
        String cpf = investidor.getCPF();
        String real = Double.toString(valorReal);
        String bitcoin = Double.toString(valorBitcoin);
        String ripple = Double.toString(valorRipple); 
        String ethereum = Double.toString(valorEthereum);
        double saldoDouble = investidor.getCarteira().getMoeda().get(0).getqte();
        String saldo = Double.toString(saldoDouble);
        Data dataOp = new Data();
        String linhaExtrato = "Data: " + dataOp.getDataOp() + " Nome: " + nome
                + " CPF: " + cpf + " Saldo Atual: " + saldo + " Real movimentado: "
                + real + " Bitcoin movimentado: " + bitcoin + 
                " Ripple movimentado: " + ripple + 
                " Ethereum movimentado: " + ethereum + " Operacao efetuada" 
                + op + "\n";
        String sql = "UPDATE extrato set cpf = ? , set operacao = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,cpf);
        statement.setString(2,linhaExtrato);
        statement.execute();
}
}