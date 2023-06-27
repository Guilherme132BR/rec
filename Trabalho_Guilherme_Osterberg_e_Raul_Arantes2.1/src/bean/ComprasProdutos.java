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
public class ComprasProdutos {
    private int idComprasProdutos;
    private int fk_Compra;
    private int fk_Produtos;
    private int quantidade;
    private double total;

    public ComprasProdutos() {
    }

    /**
     * @return the idComprasProdutos
     */
    public int getIdComprasProdutos() {
        return idComprasProdutos;
    }

    /**
     * @param idComprasProdutos the idComprasProdutos to set
     */
    public void setIdComprasProdutos(int idComprasProdutos) {
        this.idComprasProdutos = idComprasProdutos;
    }

    /**
     * @return the fk_Compra
     */
    public int getFk_Compra() {
        return fk_Compra;
    }

    /**
     * @param fkCompra the fk_Compra to set
     */
    public void setFk_Compra(int fkCompra) {
        this.fk_Compra = fkCompra;
    }

    /**
     * @return the fk_Produtos
     */
    public int getFk_Produtos() {
        return fk_Produtos;
    }

    /**
     * @param fkProduto the fk_Produtos to set
     */
    public void setFk_Produtos(int fk_Produtos) {
        this.fk_Produtos = fk_Produtos;
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
