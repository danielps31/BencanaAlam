/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Shamgar
 */
public class User extends Pengguna{
    private String id_user;
    private int no_telp;

    public User(String id_user, int no_telp, String Username, String Nama, String email, String password) {
        super(Username, Nama, email, password);
        this.id_user = id_user;
        this.no_telp = no_telp;
    }

    
    
}
