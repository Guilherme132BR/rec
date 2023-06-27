/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Plataforma;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PlataformaControle extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Plataforma  getBean(int linha) {
        return (Plataforma) lista.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Plataforma plataforma = (Plataforma) lista.get(rowIndex);
        if (columnIndex == 0) {
            return plataforma.getIdPlataforma();
        }
        if (columnIndex == 1) {
            return plataforma.getNome();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        return "";
    }
    
}
