/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Veiculo;
import model.Pneu;

/**
 *
 * @author humberto
 */
public class PneuTableModel extends AbstractTableModel{
    public static final int COL_ID = 0;
    public static final int COL_SERIE = 1;
    public static final int COL_COR = 2;
    public static final int COL_COD = 3;
    public static final int COL_ESTADO = 4;
    public static final int COL_DATA_LOCACAO = 5;
    public static final int COL_PRECO = 6;
    
    public ArrayList<Pneu> listaPneus;
    
    public PneuTableModel(ArrayList<Pneu> alPneu){
        this.listaPneus = alPneu;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Pneu p = listaPneus.get(linha);
        Object conteudo = "";
        if(coluna == COL_ID){conteudo = p.getId();}
        if(coluna == COL_SERIE){conteudo = p.getSeriePneu();}
        if(coluna == COL_COR){conteudo = p.getCorPneu();}
        if(coluna == COL_COD){conteudo = p.getCodPneu();}
        if(coluna == COL_ESTADO){conteudo = p.getEstadoPneu();}
        if(coluna == COL_DATA_LOCACAO){conteudo = p.getDataLocacao();}
        if(coluna == COL_PRECO){conteudo = p.getPreco();}
        return conteudo;
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public int getRowCount(){
        return listaPneus.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_ID){nome = "ID";}
        if(coluna == COL_SERIE){nome = "Serie";}
        if(coluna == COL_COR){nome = "Cor";}
        if(coluna == COL_COD){nome = "Codigo";}
        if(coluna == COL_ESTADO){nome = "Estado";}
        if(coluna == COL_DATA_LOCACAO){nome = "Data Locação";}
        if(coluna == COL_PRECO){nome = "Preço";}
        return nome;
    }    
}
