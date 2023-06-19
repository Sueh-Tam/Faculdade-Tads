/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora_swing;

import java.util.ArrayList;
import model.DaoPneu;
import model.Pneu;
import view.PneuView;

/**
 *
 * @author humberto
 */
public class Locadora_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoPneu daoPneu = new DaoPneu();
        ArrayList<Pneu> pneus = daoPneu.buscarTodosPneus();
        for(Pneu p : pneus){
            System.out.println(p.getCodPneu()
            + " - " + p.getEstadoPneu());
        }
        
        //new VeiculoView().setVisible(true);
        new PneuView().setVisible(true);
    }
    
}
