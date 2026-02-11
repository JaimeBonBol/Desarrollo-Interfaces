package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AyudaController {

    @FXML
    private Button btnCerrar;

    @FXML
    private void cerrarVentana() {
        // Obtener la ventana actual (Stage) y cerrarla
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }
}