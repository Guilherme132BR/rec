package dao;


import bean.Compras;
import dao.DAO_Abstract;
import dao.TesteJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilh
 */
public class Compras_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        Compras compras = (Compras) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into compras values (?, ?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras.getIdCompras());
            pstm.setDate(2, new java.sql.Date(compras.getDataCompras().getTime()));
            pstm.setInt(3, compras.getFk_Cliente() );
            pstm.setInt(4, compras.getFk_Vendedor() );
            pstm.setDouble(5, compras.getTotal() );
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
        Compras compras = (Compras) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "update compras set dataCompras= ?,fk_cliente= ?,fk_vendedor= ?, total= ? where idcompras= ?;";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(5, compras.getIdCompras());
            pstm.setDate(1, new java.sql.Date(compras.getDataCompras().getTime()));
            pstm.setInt(2, compras.getFk_Cliente() );
            pstm.setInt(3, compras.getFk_Vendedor() );
            pstm.setDouble(4, compras.getTotal() );
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
    Compras compras = (Compras) object;
    String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "delete from compras where idcompras= ?;";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras.getIdCompras());
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
    public Object list(int id) {
    Compras compras = new Compras();
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM compras where idcompras= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true) {
            compras.setIdCompras(rs.getInt("idcompras"));
            compras.setDataCompras(rs.getDate("dataCompras"));
            compras.setFk_Cliente(rs.getInt("fk_cliente"));
            compras.setTotal(rs.getDouble("total"));
            compras.setFk_Vendedor(rs.getInt("fk_vendedor"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return compras;
    }

    @Override
    public List listAll() {
   String url, user, password;
   
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        List lista = new ArrayList();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM compras";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true) {
            Compras compras = new Compras();    
            compras.setIdCompras(rs.getInt("idcompras"));
            compras.setDataCompras(rs.getDate("dataCompras"));
            compras.setFk_Cliente(rs.getInt("fk_cliente"));
            compras.setFk_Vendedor(rs.getInt("fk_Vendedor"));
            compras.setTotal(rs.getDouble("total"));
            lista.add(compras);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return lista;
    }
}
