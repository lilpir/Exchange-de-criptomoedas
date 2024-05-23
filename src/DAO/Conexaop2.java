/**
 * Esta classe fornece métodos para estabelecer uma conexão com o banco de dados.
 * Autor: Alexandre Domiciano Pierri
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Fornece métodos para estabelecer uma conexão com o banco de dados.
 */
public class Conexaop2 {
    
    /**
     * Obtém uma conexão com o banco de dados.
     * @return A conexão estabelecida.
     * @throws SQLException Se ocorrer um erro durante a conexão.
     */
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/cripotinita",
        "postgres","fei");
        
        return conexao;
    }
}
