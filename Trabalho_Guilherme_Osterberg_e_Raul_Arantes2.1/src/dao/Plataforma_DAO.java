/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.TesteJDBC;
import bean.Plataforma;
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
public class Plataforma_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        Plataforma plataforma = (Plataforma) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into plataforma values (?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, plataforma.getIdPlataforma());
            pstm.setString(2,plataforma.getNome());
            pstm.setInt(3, plataforma.getConsolePlat());
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
        Plataforma plataforma = (Plataforma) object;
        String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "update plataforma set nome=?, consoleplat=? where idplataforma=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            
            pstm.setInt(3, plataforma.getIdPlataforma());
            pstm.setString(1,plataforma.getNome());
            pstm.setInt(2, plataforma.getConsolePlat());

            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    @Override
    public void delete(Object object) {
        Plataforma plataforma = (Plataforma) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "delete from plataforma where idplataforma=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, plataforma.getIdPlataforma());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Plataforma plataforma = new Plataforma();
        String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM plataforma where idPlataforma= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()==true)
            
            {
            plataforma.setIdPlataforma(rs.getInt("idPlataforma"));
            plataforma.setNome(rs.getString("Nome"));
            plataforma.setConsolePlat(rs.getInt("ConsolePlat"));
           
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return plataforma;
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
            String sql = "select * from plataforma";
            pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
            Plataforma plataforma = new Plataforma();
            plataforma.setIdPlataforma(rs.getInt("idPlataforma"));
            plataforma.setNome(rs.getString("Nome"));
            plataforma.setConsolePlat(rs.getInt("ConsolePlat"));
                lista.add(plataforma);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }}
