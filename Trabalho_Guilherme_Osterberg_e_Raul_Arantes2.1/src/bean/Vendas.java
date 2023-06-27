/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author Guilh
 */

    public class Vendas {
   private int idVendas;
   private Date dataVendas; 
   private int fkCliente; 
   private int fkVendedor;
   private double total;

    public Vendas() {
    }

    /**
     * @return the idVendas
     */
    public int getIdVendas() {
        return idVendas;
    }

    /**
     * @param idVendas the idVendas to set
     */
    public void setIdVendas(int idVendas) {
        this.idVendas = idVendas;
    }

    /**
     * @return the data
     */
    public Date getDataVendas() {
        return dataVendas;
    }

    /**
     * @param dataVendas the dataVendas to set
     */
    public void setDataVendas(Date dataVendas) {
        this.dataVendas = dataVendas;
    }

    /**
     * @return the fkCliente
     */
    public int getFkCliente() {
        return fkCliente;
    }

    /**
     * @param fkCliente the fkCliente to set
     */
    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    /**
     * @return the fkVendedor
     */
    public int getFkVendedor() {
        return fkVendedor;
    }

    /**
     * @param fkVendedor the fkVendedor to set
     */
    public void setFkVendedor(int fkVendedor) {
        this.fkVendedor = fkVendedor;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    }
