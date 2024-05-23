package DAO;

import Model.Investidor;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * Esta classe fornece métodos para acessar e manipular dados de usuários no banco de dados.
 * Autor: Alexandre Domiciano Pierri
 */
public class UsuarioDAO {
    
    private Connection conn;

    /**
     * Construtor da classe UsuarioDAO.
     * @param conn A conexão com o banco de dados.
     */
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Realiza o login de um usuário no sistema.
     * @param usuarios O usuário que está tentando fazer login.
     * @return O resultado da consulta ao banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta SQL.
     */
    public ResultSet login(Usuario usuarios) throws SQLException{
        String sql = "select * from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuarios.getUsuario());
        statement.setString(2,usuarios.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    /**
     * Cadastra um novo investidor no sistema.
     * @param usuarios O investidor a ser cadastrado.
     * @throws SQLException Se ocorrer um erro durante a execução da inserção no banco de dados.
     */
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
    
    /**
     * Atualiza os dados de um investidor no sistema.
     * @param usuarios O investidor com os dados atualizados.
     * @param id O ID do investidor no banco de dados.
     * @throws SQLException Se ocorrer um erro durante a execução da atualização no banco de dados.
     */
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
}
