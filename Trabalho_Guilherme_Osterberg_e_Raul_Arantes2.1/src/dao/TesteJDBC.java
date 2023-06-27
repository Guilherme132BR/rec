package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author u07032685110
 */
public class TesteJDBC {
    public static void main(String[] args) {
        String url, user, password;
        url ="jdbc:mysql://10.7.0.51:33062/db_raul_torres";
        user ="raul_torres";
        password ="raul_torres";
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            //String sql = "UPDATE `usuarios` SET `apelido` = 'will' WHERE (`idusuarios` = '2');";
            String sql = "INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            //String sql = "DELETE FROM usuarios";
            stm.executeUpdate(sql);          
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Erro na conexão");
         System.exit(0);
        
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conectou");
        
        

        
        
    }
}
