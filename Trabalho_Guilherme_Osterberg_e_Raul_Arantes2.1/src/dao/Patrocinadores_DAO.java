/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.TesteJDBC;
import bean.Patrocinadores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilh
 */
public class Patrocinadores_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        Patrocinadores patrocinadores = (Patrocinadores) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into patrocinadores values (?, ?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, patrocinadores.getIdPatrocinadores());
            pstm.setString(2, patrocinadores.getNomeEmpresa());
            pstm.setString(3, patrocinadores.getCnpj());
            pstm.setString(4, patrocinadores.getCelular());
            pstm.setString(5, patrocinadores.getEmail());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
    
    }

    @Override
    public void update(Object object) {
        
        Patrocinadores patrocinadores = (Patrocinadores) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "update patrocinadores set  nomeempresa=?, cnpj=?, celular=?, email=? where idpatrocinadores=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            
            pstm.setInt(5, patrocinadores.getIdPatrocinadores());
            pstm.setString(1, patrocinadores.getNomeEmpresa());
            pstm.setString(2, patrocinadores.getCnpj());
            pstm.setString(3, patrocinadores.getCelular());
            pstm.setString(4, patrocinadores.getEmail());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }

    @Override
    public void delete(Object object) {
        
       Patrocinadores patrocinadores = (Patrocinadores) object;
       String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "delete from patrocinadores where idpatrocinadores=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, patrocinadores.getIdPatrocinadores());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Object list(int id) {
        
        Patrocinadores patrocinadores = new Patrocinadores();
        String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM patrocinadores where idpatrocinadores= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()==true)
            
            {
            patrocinadores.setIdPatrocinadores(rs.getInt("idpatrocinadores"));
            patrocinadores.setNomeEmpresa(rs.getString("NomeEmpresa"));
            patrocinadores.setCnpj(rs.getString("cnpj"));
            patrocinadores.setCelular(rs.getString("celular"));          
            patrocinadores.setEmail(rs.getString("Email"));         
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return patrocinadores;

        
    }

    @Override
    public List listAll() {
  List lista = new ArrayList();
        try {
            String url, user, password;
            url = "jdbc:mysql:/10.7.0.51:33062/db_guilherme_osterberg";
            user = "guilherme_osterberg";
            password = "guilherme_osterberg";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "select * from jogos";
            pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
            Patrocinadores patrocinadores = new Patrocinadores();
            patrocinadores.setIdPatrocinadores(rs.getInt("IdPatrocinadores"));
            patrocinadores.setNomeEmpresa(rs.getString("NomeEmpresa"));
            patrocinadores.setCnpj(rs.getString("Cnpj"));
            patrocinadores.setCelular(rs.getString("Celular"));
            patrocinadores.setEmail(rs.getString("Email"));

                lista.add(patrocinadores);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static void main(String[] args) {
    Patrocinadores patrocinadores= new Patrocinadores();
    patrocinadores.setIdPatrocinadores(1);
    patrocinadores.setNomeEmpresa("empresa mto pika");
    patrocinadores.setCnpj("05074221129");
    patrocinadores.setCelular("40028922");
    patrocinadores.setEmail("empresapika@gmail.com");
    
    
    Patrocinadores_DAO patrocinadores_DAO = new Patrocinadores_DAO(); 
    patrocinadores_DAO.insert(patrocinadores);  
        System.out.println("Deu Certo");
    }

}