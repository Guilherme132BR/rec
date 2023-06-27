/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Jogos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilh
 */
public class JogosControle extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Jogos getBean(int linha) {
        return (Jogos) lista.get(linha);
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
        Jogos jogos = (Jogos) lista.get(rowIndex);
        if (columnIndex == 0) {
            return jogos.getIdJogos();
        }
        if (columnIndex == 1) {
            return jogos.getNome();
        }
        if (columnIndex == 2) {
            return jogos.getPreco();
        }
        if (columnIndex == 3) {
            return jogos.getPlataforma();
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
        if (columnIndex == 2) {
            return "Preço";
        }
        if (columnIndex == 3) {
            return "Plataforma";
        }
        return "";
    }
}
