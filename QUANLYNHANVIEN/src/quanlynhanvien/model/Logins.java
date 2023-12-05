/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhanvien.model;

/**
 *
 * @author admin
 */
public class Logins {
    private int id;
    private String user;
    private String pass;

    public Logins() {
    }
    public Logins(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public Logins(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
}
