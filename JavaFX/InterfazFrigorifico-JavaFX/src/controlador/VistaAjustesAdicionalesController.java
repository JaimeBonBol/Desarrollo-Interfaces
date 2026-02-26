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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox; // Añadido
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import modelo.DatosCompartidos;

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
    private Slider sliderTemperature;
    @FXML
    private Label labelTemperature;
    @FXML
    private ComboBox<String> comboModo;
    @FXML
    private ComboBox<String> comboFormatoTemp;
    @FXML
    private ComboBox<String> comboMedidaAlimentos;

    @FXML
    private PasswordField passwordWifi;
    @FXML
    private Button botonWifi;
    @FXML
    private ImageView iconWifi;
    @FXML
    private ImageView iconBack;
    @FXML
    private Pane paneTemperature;
    @FXML
    private ImageView iconTemperature;
    @FXML
    private ImageView iconTemperature2;
    @FXML
    private ImageView iconSave;
    @FXML
    private Slider sliderBrillo;

    @FXML
    private CheckBox checkNotificaciones; // Nuevo CheckBox
    @FXML
    private ImageView iconInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTemperature.textProperty().bind(
                sliderTemperature.valueProperty().asString("%.1f " + "º"));

        comboModo.getItems().addAll("Eco", "Vacaciones", "UltraFreeze");
        comboFormatoTemp.getItems().addAll("ºC", "ºF");
        comboMedidaAlimentos.getItems().addAll("KG", "G");

        // --- CARGAR LOS AJUSTES GUARDADOS PREVIAMENTE ---
        sliderTemperature.setValue(DatosCompartidos.getTemperatura());
        sliderBrillo.setValue(DatosCompartidos.getBrillo());
        comboModo.setValue(DatosCompartidos.getModo());
        comboFormatoTemp.setValue(DatosCompartidos.getFormatoTemp());
        comboMedidaAlimentos.setValue(DatosCompartidos.getMedidaAlimentos());

        // Cargar CheckBox (comprobamos null por si olvidas poner el fx:id en
        // SceneBuilder)
        if (checkNotificaciones != null) {
            checkNotificaciones.setSelected(DatosCompartidos.isNotificaciones());
        }

        // Cargar estado del Wi-Fi
        if (DatosCompartidos.isWifiConectado()) {
            botonWifi.setText("Conectado");
            iconWifi.setImage(new Image(getClass().getResourceAsStream("/images/tick.png")));
            passwordWifi.setText("DIN"); // Rellenamos la contraseña para que quede bonito
        }
    }

    // --- GUARDAR LOS AJUSTES TEMPORALMENTE ---
    private void guardarAjustesTemporales() {
        DatosCompartidos.setTemperatura(sliderTemperature.getValue());
        DatosCompartidos.setBrillo(sliderBrillo.getValue());

        if (comboFormatoTemp.getValue() != null) {
            DatosCompartidos.setFormatoTemp(comboFormatoTemp.getValue());
        }
        if (comboModo.getValue() != null) {
            DatosCompartidos.setModo(comboModo.getValue());
        }
        if (comboMedidaAlimentos.getValue() != null) {
            DatosCompartidos.setMedidaAlimentos(comboMedidaAlimentos.getValue());
        }

        // Guardar Notificaciones
        if (checkNotificaciones != null) {
            DatosCompartidos.setNotificaciones(checkNotificaciones.isSelected());
        }

        // Guardar Wi-Fi (si el botón dice "Conectado", es que lo logramos)
        DatosCompartidos.setWifiConectado(botonWifi.getText().equals("Conectado"));
    }

    @FXML
    private void cambiarVistaHome(MouseEvent event) throws IOException {
        guardarAjustesTemporales();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaHome.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        Stage stage = (Stage) iconHome.getScene().getWindow();
        stage.setScene(escena);
        stage.setTitle("HOME");
    }

    @FXML
    private void cambiarVistaAlimentos(MouseEvent event) throws IOException {
        guardarAjustesTemporales();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAlimentos.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        Stage stage = (Stage) iconDish.getScene().getWindow();
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
        guardarAjustesTemporales();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAjustes.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        Stage stage = (Stage) iconSettings.getScene().getWindow();
        stage.setScene(escena);
        stage.setTitle("AJUSTES");
    }

    public String comprobarUdMedida() {
        return comboFormatoTemp.getValue();
    }

    @FXML
    private void comprobarConexionWifi(MouseEvent event) {
        if (!passwordWifi.getText().equals("DIN")) {
            botonWifi.setText("Contraseña Erronea");
        } else {
            botonWifi.setText("Conectado");
            iconWifi.setImage(new Image(getClass().getResourceAsStream("/images/tick.png")));
        }
    }

    @FXML
    private void mostrarAyudaSensible(MouseEvent event) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Ayuda — Ajustes Adicionales");
        alerta.setHeaderText("Configuración Detallada del Frigorífico");

        String textoAyuda = "Panel de configuración avanzada del frigorífico.\n\n"

                + "TEMPERATURA\n\n"
                + "Desliza la barra vertical para ajustar la temperatura "
                + "del frigorífico (rango: de -10 ºC a 10 ºC). "
                + "El valor seleccionado se muestra junto al control.\n\n"

                + "FUNCIONES DEL SISTEMA\n\n"
                + "  - Formato de temperatura: ºC o ºF.\n"
                + "  - Modo de funcionamiento: Eco, Vacaciones "
                + "o UltraFreeze.\n"
                + "  - Unidad de medida de alimentos: KG o G.\n\n"

                + "FUNCIONES INTELIGENTES\n\n"
                + "  - Brillo: desliza la barra para ajustarlo.\n"
                + "  - Notificaciones: activa o desactiva la casilla.\n"
                + "  - Conexión Wi-Fi: introduce la contraseña "
                + "correcta y pulsa el botón Conectar.\n\n"

                + "GUARDAR Y VOLVER\n\n"
                + "  - Icono de disquete: guarda los cambios y "
                + "vuelve a la pantalla de Ajustes.\n"
                + "  - Flecha atrás: vuelve sin guardar.\n\n"
                + "Los ajustes se mantienen en memoria mientras "
                + "la aplicación siga abierta.";

        TextArea areaTexto = new TextArea(textoAyuda);
        areaTexto.setEditable(false);
        areaTexto.setWrapText(true);
        areaTexto.setPrefWidth(450);
        areaTexto.setPrefHeight(320);
        areaTexto.getStyleClass().add("area-ayuda");

        alerta.getDialogPane().setContent(areaTexto);
        alerta.getDialogPane().getStylesheets().add(getClass().getResource("/vista/estilosAyuda.css").toExternalForm());
        alerta.showAndWait();
    }

}