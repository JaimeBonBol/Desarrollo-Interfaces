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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Alimento;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaAgregarAlimentoController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textCantidad;
    @FXML
    private ComboBox<String> comboUnidad;
    @FXML
    private Button btnGuardar;
    @FXML
    private Label mensaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        comboUnidad.getItems().addAll("KG", "G", "Unidades");
        
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

    @FXML
    private void CAMBIARvISTAaLIMENTOS(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAlimentos.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) iconDish.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("ALIMENTOS");
    }

    @FXML
    private void guardarAlimento(MouseEvent event) {
        
        // Recoger los datos del alimento a agregar
        String nombre = textNombre.getText();
        String unidad = comboUnidad.getValue();
        double cantidad;
    
        // Asegurar que la cantida es un numero
        try {
            cantidad = Double.parseDouble(textCantidad.getText());
            
        } catch (NumberFormatException e) {
            mensaje.setStyle("-fx-text-fill: red");
            mensaje.setText("La cantidad debe ser un número");
            return;
        }
        
        // Para que todos los campos esten rellenos
        if (nombre.isEmpty() || unidad == null) {
            mensaje.setStyle("-fx-text-fill: red");
            mensaje.setText("Todos los campos deben estar rellenos");
            return;
        }
        
        // Si se ha validado lo anterior agregamos a la lista observable el alimento
        Alimento alimentoAgregar = new Alimento(nombre, cantidad, unidad);
        modelo.DatosCompartidos.getAlimentos().add(alimentoAgregar);
        
        mensaje.setStyle("-fx-text-fill: green");
        mensaje.setText(alimentoAgregar.getNombre() + " agregado con éxito");
        textCantidad.setText("");
        textNombre.setText("");
        comboUnidad.setValue("");
    }
    
}
