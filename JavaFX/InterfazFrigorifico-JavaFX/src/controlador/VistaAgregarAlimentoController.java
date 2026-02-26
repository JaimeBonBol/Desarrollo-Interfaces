package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    private String rutaArchivoAlimentos = "src/fichero/alimentos.txt";
    @FXML
    private ImageView iconInfo;

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

        // Actualizar el txt ahora con el nuevo alimento
        modelo.DatosCompartidos.guardarAlimentosFichero(rutaArchivoAlimentos);

        mensaje.setStyle("-fx-text-fill: green");
        mensaje.setText(alimentoAgregar.getNombre() + " agregado con éxito");
        textCantidad.setText("");
        textNombre.setText("");
        comboUnidad.setValue("");
    }

    @FXML
    private void mostrarAyudaSensible(MouseEvent event) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Ayuda — Agregar Alimento");
        alerta.setHeaderText("Formulario de Nuevo Alimento");

        String textoAyuda = "Desde aquí puedes dar de alta un nuevo producto "
                + "en el inventario del frigorífico.\n\n"

                + "PASOS A SEGUIR\n\n"
                + "1. Escribe el nombre del alimento.\n"
                + "2. Introduce la cantidad (valor numérico).\n"
                + "3. Selecciona la unidad de medida en el "
                + "desplegable (KG, G o Unidades).\n"
                + "4. Pulsa el botón Guardar para confirmar.\n\n"

                + "IMPORTANTE\n\n"
                + "No dejes ningún campo vacío; el sistema "
                + "mostrará un mensaje de error si falta algún "
                + "dato. La cantidad debe ser un número válido. "
                + "Puedes usar la barra inferior para navegar a "
                + "otra pantalla sin guardar cambios.";

        TextArea areaTexto = new TextArea(textoAyuda);
        areaTexto.setEditable(false);
        areaTexto.setWrapText(true);
        areaTexto.setPrefWidth(450);
        areaTexto.setPrefHeight(280);
        areaTexto.getStyleClass().add("area-ayuda");

        alerta.getDialogPane().setContent(areaTexto);
        alerta.getDialogPane().getStylesheets().add(getClass().getResource("/vista/estilosAyuda.css").toExternalForm());
        alerta.showAndWait();
    }

}
