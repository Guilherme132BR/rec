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
public class Jogos {
    private int idJogos;
    private String nome;
    private String preco;
    private String versaoFisica;
    private Date dataLancamento;
    private String patrocinadores;
    private int plataforma;

    public int getIdJogos() {
        return idJogos;
    }

    public void setIdJogos(int idJogos) {
        this.idJogos = idJogos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getVersaoFisica() {
        return versaoFisica;
    }

    public void setVersaoFisica(String versaoFisica) {
        this.versaoFisica = versaoFisica;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @return the patrocinadores
     */
    public String getPatrocinadores() {
        return patrocinadores;
    }

    /**
     * @param patrocinadores the patrocinadores to set
     */
    public void setPatrocinadores(String patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    /**
     * @return the plataforma
     */
    public int getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }
    
    
}
