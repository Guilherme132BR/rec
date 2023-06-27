/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.TesteJDBC;
import bean.Jogos;
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
public class Jogos_DAO extends DAO_Abstract {

   
    @Override
    public void insert(Object object) {
        Jogos jogos = (Jogos) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into jogos values (?, ?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, jogos.getIdJogos());
            pstm.setString(2,jogos.getNome());
            pstm.setString(3, jogos.getPreco());
            pstm.setString(4, jogos.getVersaoFisica());
            pstm.setDate(5, new java.sql.Date(jogos.getDataLancamento().getTime() ) );
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
         Jogos jogos = (Jogos) object;
   String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "update jogos set nome=?, preco=?, versaofisica=?, datalancamento=? where idjogos=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            
            pstm.setInt(5, jogos.getIdJogos());
            pstm.setString(1,jogos.getNome());
            pstm.setString(2, jogos.getPreco());
            pstm.setString(3, jogos.getVersaoFisica());
            pstm.setDate(4, new java.sql.Date(jogos.getDataLancamento().getTime() ) );
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
         Jogos jogos = (Jogos) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "delete from jogos where idjogos=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, jogos.getIdJogos());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Jogos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Jogos jogos = new Jogos();
        String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user ="guilherme_osterberg";
        password ="guilherme_osterberg";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM jogos where idJogos= ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()==true)
            
            {
            jogos.setIdJogos(rs.getInt("idJogos"));
            jogos.setNome(rs.getString("Titulo do jogo"));
            jogos.setPreco(rs.getString("preço"));
            jogos.setVersaoFisica(rs.getString("versao fisica"));          
            jogos.setDataLancamento(rs.getDate("data lançamento"));
            //jogos.setPatrocinadores(rs.getInt("Patrocinadores"));
           // jogos.setPlataforma(rs.getInt("plataforma"));
           
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };
        return jogos;
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
                Jogos jogos = new Jogos();
            jogos.setIdJogos(rs.getInt("idJogos"));
            jogos.setNome(rs.getString("Titulo do jogo"));
            jogos.setPreco(rs.getString("preço"));
            jogos.setVersaoFisica(rs.getString("versao fisica"));          
            jogos.setDataLancamento(rs.getDate("data lançamento"));
                lista.add(jogos);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

 public static void main(String[] args) {
    Jogos jogos = new Jogos();
    jogos.setIdJogos(11);
    jogos.setNome("Hades");
    jogos.setPreco("R$45,50");
    jogos.setVersaoFisica("Não possui");
    //jogos.setDataLancamento("sei la kk");
   
    
    Jogos_DAO jogos_DAO = new Jogos_DAO(); 
    jogos_DAO.insert(jogos);  
        System.out.println("Deu Certo");
    }
    
}