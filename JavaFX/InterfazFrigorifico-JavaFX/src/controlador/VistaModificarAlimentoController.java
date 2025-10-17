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
public class VistaModificarAlimentoController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private TextField textNombreBuscar;
    @FXML
    private TextField textNombreNuevo;
    @FXML
    private TextField textCantidadNueva;
    @FXML
    private ComboBox<String> comboUnidadNueva;
    @FXML
    private Button btnModificar;
    @FXML
    private Label mensaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboUnidadNueva.getItems().addAll("KG", "G", "Unidades");
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
    private void cambiarVistaAlimentos(MouseEvent event) throws IOException {
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
    private void modificarAlimento(MouseEvent event) {
        // Obtener el nombre del alimento a modificar
        String nombreBuscado = textNombreBuscar.getText().trim();
        modelo.Alimento alimentoModificar = null;
        
        // Buscar en la lista observable si existe el alimento con el nombre
        for(modelo.Alimento alimento : modelo.DatosCompartidos.getAlimentos()){
            if (alimento.getNombre().equalsIgnoreCase(nombreBuscado)) {
                alimentoModificar = alimento;
            }
        }
        
        // Si no es null, es decir, si existe. Se obtienen los nuevos valores y se modifica
        if (alimentoModificar != null) {
            String nombreNuevo = textNombreNuevo.getText();
            String unidadNueva = comboUnidadNueva.getValue();
            double cantidadNueva;
            
            // Comprbar que la cantidad es un numero
            try {
                cantidadNueva = Double.parseDouble(textCantidadNueva.getText());

            } catch (NumberFormatException e) {
                mensaje.setStyle("-fx-text-fill: red");
                mensaje.setText("La cantidad debe ser un número");
                return;
            }
            
            // Para que todos los campos esten rellenos
            if (nombreNuevo.isEmpty() || unidadNueva == null) {
                mensaje.setStyle("-fx-text-fill: red");
                mensaje.setText("Todos los campos deben estar rellenos");
                return;
            }
            
            // Si se ha validado lo anterior modificamos a la lista observable el alimento
            alimentoModificar.setNombre(nombreNuevo);
            alimentoModificar.setCantidad(cantidadNueva);
            alimentoModificar.setUnidad(unidadNueva);

            mensaje.setStyle("-fx-text-fill: green");
            mensaje.setText(alimentoModificar.getNombre() + " modificado con éxito");
            textCantidadNueva.setText("");
            textNombreNuevo.setText("");
            comboUnidadNueva.setValue("");
            textNombreBuscar.setText("");
            
        }else{
            // Si alimentoModificar es null, es decir no esta en la lista mandamos mensaje
            mensaje.setStyle("-fx-text-fill: red");
            mensaje.setText(textNombreBuscar.getText() + " no está en la lista");
        }
    }
}
