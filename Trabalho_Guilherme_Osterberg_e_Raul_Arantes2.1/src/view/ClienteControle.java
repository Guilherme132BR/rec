/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import bean.Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilh
 */
public class ClienteControle extends AbstractTableModel {
   
          private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Cliente getBean(int linha) {
        return (Cliente) lista.get(linha);
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
        Cliente cliente = (Cliente) lista.get(rowIndex);
 if (columnIndex == 0) {
            return cliente.getIdCliente();
        }
        if (columnIndex == 1) {
            return cliente.getNome();
        }
        if (columnIndex == 2) {
            return cliente.getSobreNome();
        }
        if (columnIndex == 3) {
            return cliente.getCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "id";
        }
        if (column == 1) {
            return "nome";
        }
        if (column == 2) {
            return "Sobre Nome";
        }
        if (column == 3) {
            return "cpf";
        }

        return "";
    }
    
}
