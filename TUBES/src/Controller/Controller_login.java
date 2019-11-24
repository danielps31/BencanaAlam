/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Shamgar
 */
public class Controller_login implements ActionListener{
    private Login view;
    private Koneksi kn;
    private String idUser;
    private String username;
    private String password;
    
    public Controller_login(){
        kn = new Koneksi();
        view = new Login();
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getButtonmasuk())){
            
        }
    }
    
    public void btnLoginActionPerformed(){
        username = view.getTfUsername();
        password = view.getTfPassword();
        String nama;
        if(username.isEmpty() || password.isEmpty()){
            view.showMessage("Masukkan Username dan Password", "Error", 0);
        }else{
            if(kn.cekUserLogin(username, password)){
                idUser = kn.cariId_user(username);
                System.out.println(idUser);
                view.showMessage("Selamat Datang ", "Login Berhasil",1);
                new HomeAfterLogin();
                view.setVisible(false);
            } else {
                view.showMessage("Username Atau Password Salah", "Login Failed", 2);
            }
        }
    }   
    
}
