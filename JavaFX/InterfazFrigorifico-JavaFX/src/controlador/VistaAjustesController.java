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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Label labelDate;
    @FXML
    private Label labelTime;

    @FXML
    private ImageView iconMore;
    @FXML
    private Pane panelDateTime;
    @FXML
    private ImageView iconInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTiempoyFecha();
        // inicializarCalendario();
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
     * Funcion para inicializar los label de tiempo y fecha y se actualizen cada
     * segundo.
     */
    public void inicializarTiempoyFecha() {
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
    private void cambiarVistaAjustesAdicionales(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAjustesAdicionales.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) iconMore.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("AJUSTES ADICIONALES");
    }

    @FXML
    private void mostrarAyudaSensible(MouseEvent event) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Ayuda — Ajustes");
        alerta.setHeaderText("Ajustes Generales");

        String textoAyuda = "Pantalla de ajustes generales del frigorífico. "
                + "Aquí se muestran varios widgets informativos.\n\n"

                + "RELOJ Y FECHA\n\n"
                + "En la parte superior se muestra la hora y la fecha "
                + "del sistema en tiempo real.\n\n"

                + "WIDGETS\n\n"
                + "  - Calendario: vista mensual.\n"
                + "  - Lista de deseos: productos que te gustaría comprar.\n"
                + "  - Noticias: panel informativo.\n\n"

                + "AJUSTES ADICIONALES\n\n"
                + "Pulsa el icono de los tres puntos en la esquina "
                + "inferior derecha para acceder a la configuración "
                + "detallada: temperatura, modo, brillo, Wi-Fi, etc.\n\n"

                + "NAVEGACIÓN\n\n"
                + "Usa la barra inferior para ir a Inicio o al "
                + "Inventario de Alimentos.\n\n"
                
                + "APAGADO\n\n"
                + "El botón de encendido en la esquina superior derecha "
                + "cierra la aplicación por completo.";

        TextArea areaTexto = new TextArea(textoAyuda);
        areaTexto.setEditable(false);
        areaTexto.setWrapText(true);
        areaTexto.setPrefWidth(450);
        areaTexto.setPrefHeight(300);
        areaTexto.getStyleClass().add("area-ayuda");

        alerta.getDialogPane().setContent(areaTexto);
        alerta.getDialogPane().getStylesheets().add(getClass().getResource("/vista/estilosAyuda.css").toExternalForm());
        alerta.showAndWait();
    }

    /**
     * NO VOY A UTILIZARLO
     * Funcion para inicializar calendario, aadido a traves de dependencia maven
     * public void inicializarCalendario(){
     * // Crear el calendario
     * CalendarView calendario = new CalendarView();
     * 
     * // Configuraciones
     * calendario.setShowPageToolBarControls(false); // Barra navegacion
     * calendario.showMonthPage(); // mostrar vista mensual
     * 
     * // Ajustar el tamaño para que llene el panelCalendar
     * calendario.prefWidthProperty().bind(panelCalendar.widthProperty());
     * calendario.prefHeightProperty().bind(panelCalendar.heightProperty());
     * 
     * // Agregar el calendario al panel
     * panelCalendar.getChildren().add(calendario);
     * 
     * }
     */

}
