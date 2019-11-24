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
public class Admin extends PERSON{
    private String id_admin;

    public Admin(String id_admin, String Username, String Nama, String email, String password) {
        super(Username, Nama, email, password);
        this.id_admin = id_admin;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }
    
    
}
