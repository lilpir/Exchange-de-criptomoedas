/**
 * Classe responsável por controlar a funcionalidade de login do usuário.
 * Autor: Alexandre Domiciano Pierri
 */
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

/**
 * Controla a funcionalidade de login do usuário.
 */
public class UsuarioControl {
    private Login view;

    /**
     * Construtor da classe UsuarioControl.
     * @param view A tela de login associada a este controlador.
     */
    public UsuarioControl(Login view) {
        this.view = view;
    }
    
    /**
     * Realiza o login do usuário com base nas informações inseridas na tela de login.
     */
    public void loginUsuario(){
        // Cria um objeto Usuario com as informações de usuário e senha inseridas na tela de login
        Usuario pessoa = new Usuario(null, view.getjTextFieldUsuario().getText(), view.getjTextFieldSenha().getText(), null);
        Conexaop2 conexao = new Conexaop2();
        try{
            // Conecta ao banco de dados
            Connection conn = conexao.getConnection();
            // Cria um objeto DAO para manipular usuários no banco de dados
            UsuarioDAO dao = new UsuarioDAO(conn);
            // Realiza o login no banco de dados e obtém o resultado
            ResultSet res = dao.login(pessoa);
            // Verifica se o login foi bem-sucedido
            if(res.next()){
                // Se o login foi bem-sucedido, exibe uma mensagem de sucesso
                JOptionPane.showMessageDialog(view,"Login feito!");
                // Obtém os dados do usuário do resultado da consulta
                String Nome = res.getString("nome");
                String Usuario = res.getString("usuario");
                String CPF = res.getString("cpf");
                String Senha = res.getString("senha");
                double qtd_real = res.getDouble("qtereal");
                double qtd_bit = res.getDouble("qtebit");
                double qtd_rip = res.getDouble("qteri");
                double qtd_et = res.getDouble("qteet");
                
                // Cria uma carteira para o usuário e adiciona as moedas
                Carteira carteira = new Carteira();
                int id = res.getInt("id");
                carteira.adicionar(new Real("Real",qtd_real,1,1));
                carteira.adicionar(new Bitcoin("Bitcoin",qtd_bit,355102.38,0.0000028));
                carteira.adicionar(new Ripple("Ripple",qtd_rip,2.74,0.37));
                carteira.adicionar(new Ethereum("Ethereum",qtd_et,18976.20,0.0052));    
                
                // Cria um objeto Investidor com os dados obtidos
                Investidor investidor = new Investidor(Nome,Usuario,CPF,Senha,carteira);
                
                // Abre a página inicial do usuário
                PaginaInicial viewUsuario = new PaginaInicial(investidor, id);
                viewUsuario.setVisible(true);
                // Fecha a tela de login
                view.setVisible(false);
            }else{
                // Se o login não foi bem-sucedido, exibe uma mensagem de erro
                JOptionPane.showMessageDialog(view,"Login nao foi efetuado!"); 
            }
            
        }catch(SQLException e){
            // Se ocorrer um erro de conexão, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    }
}
