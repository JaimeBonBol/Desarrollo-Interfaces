/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jaimedam
 * 
 * Singleton para crear una instancia y esta se comparte con todos  los controladores
 * que necesitan acceder a ella. Es para que exista solo un objeto Restaurante en toda
 * la aaplicacion.
 */
public class Restaurante {
    
    private static Restaurante restauranteInstancia;
    private static Usuario usuarioSesion;
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
        
    private ObservableList<Usuario> usuarios;
    
    // Para inicializar el restaurante
    private Restaurante(){
        this.usuarios = FXCollections.observableArrayList(usuarioDAO.obtenerUsuarios());
    }
    
    public static Restaurante getInstancia(){
        
        // Se crea solo la primera vez
        if (restauranteInstancia == null) {
            restauranteInstancia = new Restaurante();
        }
        
        // Las demas veces devuelve la misma
        return restauranteInstancia;
    }
    

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }
    
}
