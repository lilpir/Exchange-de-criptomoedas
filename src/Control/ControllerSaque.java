/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

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
import View.Sacar;

/**
 *
 * @author unifapierri
 */
public class ControllerSaque {
    private Sacar view;

    public ControllerSaque(Sacar view) {
        this.view = view;
    }
    public void Saque(Investidor investidor, int id){
       view.getjTextAreaAntes().setText("Nome: "+ investidor.getNome()+
                "\nCPF: "+ investidor.getCPF()+
                "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
       float pre = (float) investidor.getCarteira().getMoeda().get(0).getqte();
       String dep = view.getjTextFieldQte().getText();
       try{
           float depFloat = Float.parseFloat(dep);
           float total = pre - depFloat;
           if(total > 0){
               Moeda aux = investidor.getCarteira().getMoeda().get(0);
            aux.setqte(total);
            view.getjTextAreaDepois().setText("Nome: "+ investidor.getNome()+
                 "\nCPF: "+ investidor.getCPF()+
                 "\n\nReal: "+ investidor.getCarteira().getMoeda().get(0).getqte()+
                 "\nBitcoin: "+ investidor.getCarteira().getMoeda().get(1).getqte()+
                 "\nRipple: "+ investidor.getCarteira().getMoeda().get(2).getqte()+
                 "\nEthereum: "+ investidor.getCarteira().getMoeda().get(3).getqte());
           }
           else{
               JOptionPane.showMessageDialog(view, dep + "R$ excede a quantia de dinehiro que você possui");
           }
           
       } catch(NumberFormatException e){
           JOptionPane.showMessageDialog(view,"Digite um número!"); 
       }
    }
}
