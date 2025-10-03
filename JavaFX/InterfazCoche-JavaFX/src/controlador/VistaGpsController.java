/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import com.sothawo.mapjfx.Configuration;
import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.MapView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class VistaGpsController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconMultimedia;
    @FXML
    private ImageView iconCarSettings;
    @FXML
    private ImageView iconPhone;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private Pane panelMapa;
    @FXML
    private Pane panelDestino;
    @FXML
    private Pane panelDirecciones;
    
    private MapView mapView;
    @FXML
    private Label labelTime;
    @FXML
    private Label labelDate;
    @FXML
    private ImageView iconLupa;
    @FXML
    private TextField textFielBusquedaDestino;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTiempoyFecha();
        inicializarMapa();       

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
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconPowerOff.getScene().getWindow();
        
        stage.close();
    }
    
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
    
    public void inicializarMapa(){
        // Crear el MapView
        mapView = new MapView();
        mapView.initialize(Configuration.builder()
                .showZoomControls(true) // muestra botones de zoom
                .build());
        
        
        // Ajustar tamaño del mapa al Pane
        mapView.prefWidthProperty().bind(panelMapa.widthProperty());
        mapView.prefHeightProperty().bind(panelMapa.heightProperty());
        
        // Añadir el MapView al Pane
        panelMapa.getChildren().add(mapView);
        
        mapView.setCenter(new Coordinate(37.8882, -4.7794)); // lat, lon
        mapView.setZoom(14); // nivel de zoom
    }
    
    
    
}
