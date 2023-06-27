/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.TesteJDBC;
import bean.Usuarios;
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
public class Usuarios_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into usuarios values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuario());
            pstm.setString(2, usuarios.getNome());
            pstm.setString(3, usuarios.getApelido());
            pstm.setString(4, usuarios.getCpf());
            pstm.setDate(5, new java.sql.Date(usuarios.getDataNasc().getTime() ) );
            pstm.setString(6, usuarios.getSenha());
            pstm.setInt(7, usuarios.getNivel());
            pstm.setString(8, usuarios.getAtivo());
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

        Usuarios usuarios = (Usuarios) object;

        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            String sql = "update usuarios set nome=?, apelido=?, cpf=?, dataNasc=?, senha=?, nivel=?, ativo=? where idusuarios= ?";
            stm.executeLargeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setInt(8, usuarios.getIdUsuarios());
            pstm.setString(1, usuarios.getNome());
            pstm.setString(2, usuarios.getApelido());
            pstm.setString(3, usuarios.getCpf());
            pstm.setDate(4, new java.sql.Date( usuarios.getDataNasc().getTime() ));
            pstm.setString(5, usuarios.getSenha());
            pstm.setInt(6, usuarios.getNivel());
            pstm.setString(7, usuarios.getAtivo());
            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;

        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "delete from usuarios where idusuarios=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();

        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
        user = "guilherme_osterberg";
        password = "guilherme_osterberg";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);

            String sql = "select * from usuario where idusuario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                usuarios.setIdUsuario(rs.getInt("idusuarios"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNasc(rs.getDate("dataNasc"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
       
            public List listAll() {        
        List lista = new ArrayList();
        try {
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
            user = "guilherme_osterberg";
            password = "guilherme_osterberg";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pstm;
            String sql = "select * from usuarios ";
            pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();            
            while (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios( rs.getInt("idusuarios"));
                usuarios.setNome( rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setSenha(rs.getString("senha"));                
                usuarios.setDataNasc( rs.getDate("dataNasc"));
                usuarios.setNivel( rs.getInt("nivel"));
                usuarios.setAtivo( rs.getString("ativo"));
                lista.add(usuarios);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
            
        public Usuarios fazerLogin(String apelido, String senha) {
        Usuarios usuarios = null;
               
        String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_guilherme_osterberg";
            user = "guilherme_osterberg";
            password = "guilherme_osterberg";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM usuarios WHERE apelido = ? AND senha = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, apelido);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuarios = new Usuarios();
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setSenha(rs.getString("senha"));
            }

            rs.close();
            pstm.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão");
            System.exit(0);

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        };

        return usuarios;
    }

    // QUEBRA DE LINHA PRA N CONFUNDIR
    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.setIdUsuarios(11);
        usuarios.setNome("Raul");
        usuarios.setApelido("Torres");
        usuarios.setCpf("05074221129");
        //usuarios.setDatanascimento("");
        usuarios.setSenha("1234");
        usuarios.setNivel(1);
        usuarios.setAtivo("S");

        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();
        usuarios_DAO.insert(usuarios);
        System.out.println("Deu Certo");
    }

}
