/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Restaurante;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaLoginController implements Initializable {

    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnAtras;
    
    private Restaurante restaurante = Restaurante.getInstancia();
    
    private UsuarioDAO UsuarioDAO  = new UsuarioDAO();
    private VistaHomeController homeController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginUsuario(MouseEvent event) throws IOException {
        String username = textFieldUsuario.getText();
        String password = textFieldPassword.getText();
        
        Usuario usuario = UsuarioDAO.autenticar(username, password);
        
        if (usuario == null) {
            mostrarAlerta("Info", "Error al autenticar");
        }else{
            restaurante.setUsuarioSesion(usuario);
            cambviarVistaHome();
        }
    }
    
    
    public void mostrarAlerta(String tipo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(tipo);
            alerta.setContentText(mensaje);
            
            alerta.showAndWait();
    }

    @FXML
    private void cerrarVentana(MouseEvent event) throws IOException {
        cambviarVistaHome();
    }
    
    public void cambviarVistaHome() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaHome.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) btnAtras.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("HOME");
    }
}
