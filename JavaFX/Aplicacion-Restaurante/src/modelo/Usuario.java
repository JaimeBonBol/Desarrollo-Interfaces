/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaimedam
 */
public class Usuario {
    
    private String username;
    private String password;
    private RolUsuario rol;

    public Usuario(String username, String password, RolUsuario rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return username + "[" + rol + "]";
    }
    
}
