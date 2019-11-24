/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import java.util.logging.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.*;

/**
 *
 * @author fikri
 */
public class Koneksi {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<User> user = new ArrayList<>();

    public Koneksi() {
        loadUser();
    }

    public void connect(){
            String url = "jdbc:mysql://localhost/bencana";
            String user = "root";
            String pass = "";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.out.println("Not Connected");
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }

    public void loadUser() {
        connect();
        try {
            String query = "SELECT * FROM user";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                user.add(new User(rs.getString("id_user"), rs.getInt("no_telp"), rs.getString("username"), rs.getString("nama"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void addUser(User u) {
        connect();
        String query = "INSERT INTO user VALUES (";
        query += "'" + u.getId_user() + "',";
        query += "'" + u.getNo_telp() + "',";
        query += "'" + u.getUsername() + "',";
        query += "'" + u.getNama() + "'";
        query += "'" + u.getEmail() + "'";
        query += "'" + u.getPassword() + "'";
        query += ")";
        if (manipulate(query)) user.add(u);
        disconnect();
    }

    public boolean cekDuplikatId(String id_user){
        boolean cek = false;
        for (User usr : user) {
            if (usr.getId_user().equals(id_user)){
                cek = true;
                break;
            }
        }
        return cek;
    }

    public void delUser(String id_user) {
        connect();
        String query = "DELETE FROM user WHERE id_user='" + id_user + "'";
        if (manipulate(query)){
            for (User usr : user) {
                if (usr.getId_user().equals(usr)){
                    user.remove(id_user);
                    break;
                }
            }
        }
        disconnect();
    }

    public void updateUser(User u) {
        connect();
        String query = "UPDATE user SET";
        query += " no_telp='" + u.getNo_telp() + "',";
        query += " username='" + u.getUsername()+ "',";
        query += " nama='" + u.getNama() + "',";
        query += " email='" + u.getEmail() + "'";
        query += " password='" + u.getPassword() + "'";
        query += " WHERE nim='" + u.getId_user() + "'";
        if (manipulate(query)){
            for (User usr : user) {
                if (usr.getId_user().equals(u.getId_user())){
                    usr.setNo_telp(u.getNo_telp());
                    usr.setUsername(u.getUsername());
                    usr.setNama(u.getNama());
                    usr.setEmail(u.getEmail());
                    usr.setPassword(u.getPassword());
                    break;
                }
            }
        }
        disconnect();
    }
    
    public String cariId_user(String u){
        String id = null;
        for(User usr : user){
            if (usr.getUsername().equals(u)) {
                id = usr.getId_user();
            }
        } return id;
    }
        
    public boolean cekUserLogin(String q, String p){
        boolean cek = false;
        for (User u : user) {
            if (u.getUsername().equals(q) && u.getPassword().equals(p)){
                cek = true;
                break;
            }
        }
        return cek;
    }
}
