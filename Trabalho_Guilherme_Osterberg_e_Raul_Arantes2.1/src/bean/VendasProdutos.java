/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Guilh
 */
public class VendasProdutos{
    private int idVendasProduto;
    private int fkVendas;
    private int fkProdutos;
    private int quantidade;
    private double valorUnitario;

    public VendasProdutos() {
    }

    /**
     * @return the idVendasProduto
     */
    public int getIdVendasProduto() {
        return idVendasProduto;
    }

    /**
     * @param idVendasProduto the idVendasProduto to set
     */
    public void setIdVendasProduto(int idVendasProduto) {
        this.idVendasProduto = idVendasProduto;
    }

    /**
     * @return the fkVendas
     */
    public int getFkVendas() {
        return fkVendas;
    }

    /**
     * @param fkVendas the fkVendas to set
     */
    public void setFkVendas(int fkVendas) {
        this.fkVendas = fkVendas;
    }

    /**
     * @return the fkProdutos
     */
    public int getFkProdutos() {
        return fkProdutos;
    }

    /**
     * @param fkProdutos the fkProdutos to set
     */
    public void setFkProdutos(int fkProdutos) {
        this.fkProdutos = fkProdutos;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
