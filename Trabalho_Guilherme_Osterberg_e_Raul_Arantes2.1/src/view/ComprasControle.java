/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Compras;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilh
 */
public class ComprasControle  extends AbstractTableModel{
    List lista;
    public void setList(List lista){
    this.lista = lista;
    }
    public  Compras getBean (int row){
    return (Compras)lista.get(row);
    }
    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Compras compras = (Compras) lista.get(rowIndex);
        if (columnIndex == 0){
        return compras.getIdCompras();
        }
        if (columnIndex == 1){
        return compras.getFk_Cliente();
        }
        if (columnIndex == 2){
        return compras.getFk_Vendedor();
        }
        if (columnIndex == 3){
        return compras.getDataCompras();
        }
        if (columnIndex == 4){
        return compras.getTotal();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "Fk_Cliente";
        }
        if (column == 2){
        return "Fk_vendedor";
        }
        if (column == 3){
        return "DataCompras";
        }
        if (column == 4){
        return "Total";
        }
               
        return "";
    };
}
