/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.Conexaop2;
import DAO.UsuarioDAO;
import Model.Investidor;
import View.Deposito;
import Model.Carteira;
import Model.Ethereum;
import Model.Investidor;
import Model.Moeda;
import View.PaginaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Consulta;

/**
 *
 * @author unifapierri
 */
public class ControllerDeposito {
    private Deposito view;
    
    public ControllerDeposito(Deposito view){
        this.view = view;
    }
    
    public void deposito(Investidor investidor, int id){
        view.getjTextAreaAntes().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
        
       double pre =  investidor.getCarteira().getMoeda().get(0).getqte();       
       String dep = view.getjTextFieldQte().getText();
       Conexaop2 conexao = new Conexaop2();
       double depFloat = Double.parseDouble(dep);
       double total = depFloat + pre;

        investidor.getCarteira().getMoeda().get(0).setqte(total);
           
        view.getjTextAreaDepois().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
           
            dao.att(investidor,id);
           
       } catch(SQLException e){
           JOptionPane.showMessageDialog(view,"Digite um número!"); 
       }
        
    }
}
