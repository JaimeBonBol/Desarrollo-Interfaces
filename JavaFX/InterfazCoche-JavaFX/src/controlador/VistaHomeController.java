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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaHomeController implements Initializable {

    @FXML
    private AnchorPane vistaHome;
    @FXML
    private Label labelTime;
    @FXML
    private Label labelDate;
    @FXML
    private ImageView iconGps;
    @FXML
    private ImageView iconMultimedia;
    @FXML
    private ImageView iconCarSettings;
    @FXML
    private ImageView iconPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarVistaGps(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaGps.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) iconGps.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("GPS");
    }
    
}
