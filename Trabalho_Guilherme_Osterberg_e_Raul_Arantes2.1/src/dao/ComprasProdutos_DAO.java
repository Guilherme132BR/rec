/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ComprasProdutos;
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
public class ComprasProdutos_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        ComprasProdutos comprasProdutos = (ComprasProdutos) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into compra_produtos values (?, ?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, comprasProdutos.getIdComprasProdutos());
            pstm.setInt(2, comprasProdutos.getFk_Compra() );
            pstm.setInt(3, comprasProdutos.getFk_Produtos() );
            pstm.setInt(4, comprasProdutos.getQuantidade());
            pstm.setDouble(5, comprasProdutos.getTotal());
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
           ComprasProdutos comprasProdutos = (ComprasProdutos) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "update compra_produtos fkcompra= ?,fkproduto= ?,quantidade= ?,total= ? where idcompra_produtos= ?;";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, comprasProdutos.getIdComprasProdutos());
            pstm.setInt(2, comprasProdutos.getFk_Compra() );
            pstm.setInt(3, comprasProdutos.getFk_Produtos() );
            pstm.setInt(4, comprasProdutos.getQuantidade());
            pstm.setDouble(5, comprasProdutos.getTotal());
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
    ComprasProdutos comprasProdutos = (ComprasProdutos) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "delete from compra_produtos where compra_produtos= ?;";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, comprasProdutos.getIdComprasProdutos());
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
        ComprasProdutos comprasProdutos = new ComprasProdutos();
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM compras_produtos where idcompra_produtos= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true) {
            comprasProdutos.setIdComprasProdutos(rs.getInt("compras_produtos"));
            comprasProdutos.setFk_Compra(rs.getInt("fk_compra"));
            comprasProdutos.setFk_Produtos(rs.getInt("fk_produtos"));
            comprasProdutos.setQuantidade(rs.getInt("quantidade"));
            comprasProdutos.setTotal(rs.getDouble("total"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return comprasProdutos;
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
            String sql = "SELECT * FROM compras_produtos where idcompra_produtos= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true) {
            ComprasProdutos comprasProdutos = new ComprasProdutos();
            comprasProdutos.setIdComprasProdutos(rs.getInt("compra_produtos"));
            comprasProdutos.setFk_Compra(rs.getInt("fkcompra"));
            comprasProdutos.setFk_Produtos(rs.getInt("fkproduto"));
            comprasProdutos.setQuantidade(rs.getInt("quantidade"));
            comprasProdutos.setTotal(rs.getDouble("total"));
            lista.add(comprasProdutos);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return lista;}
}
