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
public class Compras {

    private int idCompras;
    private Date dataCompras;
    private int fk_Cliente;
    private int fk_Vendedor;
    private double total;

    public Compras() {
    }

    /**
     * @return the idCompras
     */
    public int getIdCompras() {
        return idCompras;
    }

    /**
     * @param idCompras the idCompras to set
     */
    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }


    /**
     * @return the fk_Jogos
     */
    public int getFk_Cliente() {
        return fk_Cliente;
    }

    /**
     * @param fkCliente the fk_Jogos to set
     */
    public void setFk_Cliente(int fkCliente) {
        this.fk_Cliente = fkCliente;
    }

    /**
     * @return the fk_Produto
     */
    public int getFk_Vendedor() {
        return fk_Vendedor;
    }

    /**
     * @param fk_Vendedor the fk_Produto to set
     */
    public void setFk_Vendedor(int fk_Vendedor) {
        this.fk_Vendedor = fk_Vendedor;
    }
    
        public Date getDataCompras() {
        return dataCompras;
    }

    /**
     * @param dataCompras the dataCompras to set
     */
    public void setDataCompras(Date dataCompras) {
        this.dataCompras = dataCompras;
    }

        public int getFk_cliente() {
        return fk_Cliente;
    }

    /**
     * @param fk_cliente the fk_Cliente to set
     */
    public void setFk_cliente(int fk_cliente) {
        this.fk_Cliente = fk_cliente;
    }
    
        /**
     * @return the fk_Vendedor
     */
    public int getFk_vendedor() {
        return fk_Vendedor;
    }

    /**
     * @param fk_vendedor the fk_Vendedor to set
     */
    public void setFk_vendedor(int fk_vendedor) {
        this.fk_Vendedor = fk_vendedor;
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
