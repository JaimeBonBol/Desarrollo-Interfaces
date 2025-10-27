/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Restaurante;
import modelo.RolUsuario;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaHomeController implements Initializable {

    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnGestionUsuarios;
    @FXML
    private Button btnGestionInventario;
    @FXML
    private TextField textFieldSesion;
    @FXML
    private Button btnLogin;
    
    private Restaurante restaurante = Restaurante.getInstancia();
    @FXML
    private Button btnLogOut;
    @FXML
    private ImageView iconoApagar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comprobarUsuarioSesion();
        comprobarRolSesion();
    }

    @FXML
    private void deslogearse(MouseEvent event) {
        restaurante.setUsuarioSesion(null);
        
        comprobarUsuarioSesion();
        comprobarRolSesion();
    }

    @FXML
    private void cambiarVistaLogin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaLogin.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) btnLogin.getScene().getWindow();

        // Reemplazar la escena actual
        stage.centerOnScreen();
        stage.setScene(escena);
        stage.setTitle("HOME");
    }
    
    public void comprobarUsuarioSesion(){
        if (restaurante.getUsuarioSesion() == null) {
            textFieldSesion.setText("Sesión no iniciada");
            btnLogOut.setVisible(false);
            btnLogin.setVisible(true);
            
            btnGestionInventario.setVisible(false);
            btnGestionUsuarios.setVisible(false);
        }else{
            textFieldSesion.setText(restaurante.getUsuarioSesion().toString());
            
            btnLogOut.setVisible(true);
            btnLogin.setVisible(false);
        }
    }
    
    @FXML
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconoApagar.getScene().getWindow();
        
        stage.close();
    }
    
    public void comprobarRolSesion() {
        if (restaurante.getUsuarioSesion() == null) {
            // Si no hay usuario logueado ocultar
            btnGestionInventario.setVisible(false);
            btnGestionUsuarios.setVisible(false);
            return;
        }

        RolUsuario rol = restaurante.getUsuarioSesion().getRol();

        if (rol == RolUsuario.ADMIN) {
            btnGestionInventario.setVisible(true);
            btnGestionUsuarios.setVisible(true);
        } else {
            btnGestionInventario.setVisible(false);
            btnGestionUsuarios.setVisible(false);
        }
    }

    @FXML
    private void cambiarVistaGestionUsuarios(MouseEvent event) {
        
    }

}
