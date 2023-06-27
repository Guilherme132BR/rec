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
public class Patrocinadores {
    private int idPatrocinadores;
    private String NomeEmpresa;
    private String cnpj;
    private String celular;
    private String email;

    public int getIdPatrocinadores() {
        return idPatrocinadores;
    }

    public void setIdPatrocinadores(int idPatrocinadores) {
        this.idPatrocinadores = idPatrocinadores;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
