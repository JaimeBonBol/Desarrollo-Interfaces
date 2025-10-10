/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaHomeController implements Initializable {

    @FXML
    private Label labelDate;
    @FXML
    private Label labelTime;
    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private ImageView imagenAlimentos;
    @FXML
    private Pane panelDateTime;
    
    private boolean alimentosVisibles = false;
    @FXML
    private ImageView iconFreeze;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTiempoyFecha();
    }    
    
    
    /**
     * Funcion para inicializar los label de tiempo y fecha y se actualizen cada segundo.
     */
    public void inicializarTiempoyFecha(){
    // Formato de hora y fecha
    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Timeline que se ejecuta cada segundo
    Timeline reloj = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        LocalDateTime ahora = LocalDateTime.now();
        labelTime.setText(formatoHora.format(ahora));
        labelDate.setText(formatoFecha.format(ahora));
    }));
    reloj.setCycleCount(Timeline.INDEFINITE);
    reloj.play();
    }


    @FXML
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconPowerOff.getScene().getWindow();
        
        stage.close();
    }

    @FXML
    private void mostrarAlimentos(MouseEvent event) {
        if (!alimentosVisibles) {
            imagenAlimentos.setOpacity(1.0);
            panelDateTime.setOpacity(0.0);
            alimentosVisibles = true;
        }
        else{
            imagenAlimentos.setOpacity(0.1);
            panelDateTime.setOpacity(1.0);
            alimentosVisibles = false;
        }
    }
    
}
