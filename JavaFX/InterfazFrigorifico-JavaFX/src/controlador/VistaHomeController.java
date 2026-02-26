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
    @FXML
    private ImageView iconInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTiempoyFecha();
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
        } else {
            imagenAlimentos.setOpacity(0.1);
            panelDateTime.setOpacity(1.0);
            alimentosVisibles = false;
        }
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
    private void mostrarAyudaSensible(MouseEvent event) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Ayuda — Inicio");
        alerta.setHeaderText("Pantalla Principal (Home)");

        String textoAyuda = "Bienvenido a la pantalla principal del frigorífico inteligente.\n\n"

                + "RELOJ Y FECHA\n\n"
                + "En el centro de la pantalla se muestra la hora actual "
                + "y la fecha, actualizándose en tiempo real.\n\n"

                + "VISIÓN INTERIOR\n\n"
                + "Toca el fondo de la pantalla para simular "
                + "la iluminación del interior del frigorífico "
                + "y ver los alimentos almacenados. "
                + "Tócalo de nuevo para apagar la luz.\n\n"

                + "BARRA DE NAVEGACIÓN\n\n"
                + "  - Icono de bandeja (izquierda): Inventario de alimentos.\n"
                + "  - Icono de casa (centro): Estás aquí.\n"
                + "  - Icono de engranaje (derecha): Ajustes.\n\n"

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

}
