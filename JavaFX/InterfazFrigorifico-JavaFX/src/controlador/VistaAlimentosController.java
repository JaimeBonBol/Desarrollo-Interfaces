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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaAlimentosController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarVistaHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaHome.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) iconHome.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("HOME"); 
    }

    @FXML
    private void cambiarVistaAjustes(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAjustes.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) iconSettings.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("AJUSTES");
    }

    @FXML
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconPowerOff.getScene().getWindow();
        
        stage.close();
    }
    
}
