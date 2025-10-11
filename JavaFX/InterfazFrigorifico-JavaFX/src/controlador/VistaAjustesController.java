/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import com.calendarfx.view.CalendarView;


/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaAjustesController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private Pane panelDateTime;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTiempoyFecha();
        //inicializarCalendario();
    }    

    @FXML
    private void salirApp(MouseEvent event) {
        Stage stage = (Stage) iconPowerOff.getScene().getWindow();
        
        stage.close();
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
    
    
    /** NO VOY A UTILIZARLO
     * Funcion para inicializar calendario, aadido a traves de dependencia maven
    public void inicializarCalendario(){
        // Crear el calendario
        CalendarView calendario = new CalendarView();
        
        // Configuraciones
        calendario.setShowPageToolBarControls(false); // Barra navegacion
        calendario.showMonthPage(); // mostrar vista mensual

        // Ajustar el tamaño para que llene el panelCalendar
        calendario.prefWidthProperty().bind(panelCalendar.widthProperty());
        calendario.prefHeightProperty().bind(panelCalendar.heightProperty());

        // Agregar el calendario al panel
        panelCalendar.getChildren().add(calendario);

    }*/
    
    
}
