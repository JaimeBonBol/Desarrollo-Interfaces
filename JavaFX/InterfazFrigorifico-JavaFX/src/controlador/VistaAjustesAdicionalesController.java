/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaAjustesAdicionalesController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private ImageView iconBack;
    @FXML
    private Slider sliderTemperature;
    @FXML
    private Label labelTemperature;
    @FXML
    private ImageView iconTemperature;
    @FXML
    private Pane paneTemperature;
    @FXML
    private ImageView iconTemperature2;
    @FXML
    private ImageView iconSave;
    @FXML
    private ComboBox<String> comboModo;
    @FXML
    private ComboBox<String> comboUdMedida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obtiene la propiedad del valor del slider, formatea el numero con un decimal y 
        // le añade ºC. .bind() hace que el label se actualize en timepo real cuando
        // se mueve el slider.
        //labelTemperature.textProperty().bind(
        //    sliderTemperature.valueProperty().asString("%.1f " + comprobarUdMedida())
        //);
        
        labelTemperature.textProperty().bind(
            Bindings.createStringBinding(() -> {
                double tempC = sliderTemperature.getValue();
                String unidad = comboUdMedida.getValue();
                if (unidad == null) unidad = "ºC"; // valor por defecto

                double tempFinal;
                if (unidad.equals("ºF")) {
                    tempFinal = tempC * 9 / 5 + 32; // convertir a Fahrenheit
                } else {
                    tempFinal = tempC; // mantener Celsius
                }

                return String.format("%.1f %s", tempFinal, unidad);
            }, sliderTemperature.valueProperty(), comboUdMedida.valueProperty())
        );
        
        comboModo.getItems().addAll("Eco", "Vacaciones", "UltraFreeze");        
        comboUdMedida.getItems().addAll("ºC", "ºF");
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
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconPowerOff.getScene().getWindow();
        
        stage.close();
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
    
    public String comprobarUdMedida(){
        return comboUdMedida.getValue();
    }
    
}
