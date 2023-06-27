/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Patrocinadores;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilh
 */
public class PatrocinadoresControle  extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Patrocinadores getBean(int linha) {
        return (Patrocinadores) lista.get(linha);
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
        Patrocinadores patrocinadores = (Patrocinadores) lista.get(rowIndex);
        if (columnIndex == 0) {
            return patrocinadores.getIdPatrocinadores();
        }
        if (columnIndex == 1) {
            return patrocinadores.getNomeEmpresa();
        }
        if (columnIndex == 2) {
            return patrocinadores.getCnpj();
        }
        if (columnIndex == 3) {
            return patrocinadores.getEmail();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Nome empresa";
        }
        if (columnIndex == 2) {
            return "CNPJ";
        }
        if (columnIndex == 3) {
            return "Email";
        }
        return "";
    }    
}
