/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Restaurante;
import modelo.RolUsuario;
import modelo.Usuario;


/**
 *
 * @author jaimedam
 */
public class UsuarioDAO {
    
    private static final String ARCHIVO_USUARIOS = "src/ficheros/usuarios.txt";
    
    
    /**
     * Obetener todos los usuairios del archivo txt
     * @return 
     */
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS));
            
            String linea;
            while ((linea = br.readLine()) != null) {                
                String[] palabrasLinea = linea.split(";");
                
                String username = palabrasLinea[0];
                String passworsd = palabrasLinea[1];
                RolUsuario rol = RolUsuario.valueOf(palabrasLinea[2]);
                
                usuarios.add(new Usuario(username, passworsd, rol));
            }
            
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return usuarios;
    }
    
    /**
     * Actualiza el archivo de usuarios
     * @param usuarios 
     */
    public void actualizarArchivo(List<Usuario> usuarios){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS));
            
            for(Usuario usuario : usuarios){
                bw.write(usuario.getUsername() + ";" + usuario.getPassword() + ";" + usuario.getRol());
                bw.newLine();
            }
            
            bw.close();
        } catch (Exception e) {
        }
    }
    
    /**
     * Agregar usuario nuevo, se proporciona un objeto Usuario
     * @param usuario 
     */
    public void agregarUsuario(Usuario usuario){
        // Se obtiene los usuarios actuales
        List<Usuario> usuarios = obtenerUsuarios();
        
        // Comprobar que el usuario a añadir no existe ya en el txt
        for(Usuario u : usuarios){
            if (u.getUsername().equals(usuario.getUsername())) {
                return;
            }
        }
        
        // Si no existe, se añade a la lista y se actualiza en el txt
        usuarios.add(usuario);
        actualizarArchivo(usuarios);
        // Actualizar la observablelist del restaurante
        Restaurante.getInstancia().getUsuarios().setAll(usuarios);
    }
    
    /**
     * Eliminar usuario, se porporciona un objeto Usuario
     * @param usuario 
     */
    public void eliminarUsuario(Usuario usuario){
        // Se obtiene los usuarios actuales
        List<Usuario> usuarios = obtenerUsuarios();
        
        // Comprobar que el usuario a eliminar existe en el txt
        for(Usuario u : usuarios){
            if (u.getUsername().equals(usuario.getUsername())) {
                usuarios.remove(u);
                actualizarArchivo(usuarios);
                // Actualizar la observablelist del restaurante
                Restaurante.getInstancia().getUsuarios().setAll(usuarios);
            }
        }
    }
    
    
    /**
     * Autenticar usuario a partir de su username y contraseña
     * @param username
     * @param password
     * @return 
     */
    public Usuario autenticar(String username, String password){
        // Se obtiene los usuarios actuales
        List<Usuario> usuarios = obtenerUsuarios();
        
        // Comprobar si el usuario existe para devolverlo, o null en caso de que no 
        // se encuentre.
        for(Usuario u : usuarios){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        
        // Si no esta en el txt devuelve null
        return null;
    }
}
