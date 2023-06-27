/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.TesteJDBC;
import bean.Vendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilh
 */
public class Vendedor_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        Vendedor vendedor = (Vendedor) object;
   String url, user, password;
        url ="jdbc:mysql://127.0.0.1:3306/guilherme_osterberg";
        user ="root";
        password ="";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into vendedor values (?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedor.getIdVendedor());
            pstm.setString(2,vendedor.getNome());
            pstm.setString(3, vendedor.getCpf());
            //pstm.setDate(4, new java.sql.Date( vendedor.getDataNasc().getTime() ));  
            pstm.setString(4, vendedor.getGenero());
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
    String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/guilherme_osterberg  ";
        user = "root";
        password = "";

        try {
            Vendedor vendedor = (Vendedor) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            String sql = "update vendedor set nome=?, cpf=?, dataNasc=?, genero=? where idvendedor= ?";
            stm.executeLargeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setInt(5, vendedor.getIdVendedor());
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setDate(3, new java.sql.Date( vendedor.getDataNasc().getTime() ));
            pstm.setString(4, vendedor.getGenero());
            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
       Vendedor vendedor=(Vendedor) object;
       
       String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/guilherme_osterberg";
        user = "root";
        password = "";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "delete from vendedor where idvendedor=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedor.getIdVendedor());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Vendedor vendedor = new Vendedor();
        
                String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/guilherme_osterberg";
        user = "root";
        password = "";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);

            String sql = "select * from vendedor where idvendedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                vendedor.setIdVendedor(rs.getInt("idvendedor"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setDataNasc(rs.getDate("dataNasc"));
                vendedor.setGenero(rs.getString("genero"));

    } }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendedor;
    }


    @Override
    public List listAll() {
List lista = new ArrayList();
        try {
            String url, user, password;
            url = "jdbc:mysql://127.0.0.1:3306/guilherme_osterberg";
            user = "root";
            password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "select * from vendedor ";
            pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdVendedor( rs.getInt("idvendedor"));
                vendedor.setNome( rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setDataNasc( rs.getDate("dataNasc"));
                vendedor.setGenero( rs.getString("genero"));
                lista.add(vendedor);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }}