/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Investidor;
import View.PaginaInicial;
import View.Sacar;

/**
 *
 * @author unifapierri
 */
public class PIcontrol {
    private PaginaInicial view;
    
    public PIcontrol(PaginaInicial view){
        this.view = view;
    }
    
    public void abre_saque(Investidor investidor, int id){
       Sacar sc = new Sacar(investidor, id);
       sc.setVisible(true);
    }
}
