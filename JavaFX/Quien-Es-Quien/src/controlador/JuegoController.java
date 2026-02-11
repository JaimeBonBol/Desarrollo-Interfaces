package controlador;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.JuegoModelo;
import modelo.Personaje;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JuegoController {

    @FXML private GridPane gridPersonajes;
    @FXML private TextArea areaLog;
    @FXML private ComboBox<String> comboPreguntas;
    @FXML private Label lblVidas; 
    @FXML private Button btnPreguntar;
    @FXML private Button btnReiniciar;

    private JuegoModelo modelo;

    @FXML
    public void initialize() {
        modelo = new JuegoModelo();
        iniciarPartidaUI();
    }
    
    private void iniciarPartidaUI() {
        actualizarVidasUI();
        areaLog.setText("¡NUEVA PARTIDA!\nHe elegido un personaje secreto.\nTienes 3 vidas.");
        
        cargarPreguntas();
        pintarTablero();
        
        // Habilitar controles
        gridPersonajes.setDisable(false);
        btnPreguntar.setDisable(false);
        comboPreguntas.setDisable(false);
    }

    private void cargarPreguntas() {
        if (comboPreguntas.getItems().isEmpty()) {
            comboPreguntas.getItems().add("¿Es hombre?");
            comboPreguntas.getItems().add("¿Es mujer?");
            comboPreguntas.getItems().add("¿Tiene gafas?");
            comboPreguntas.getItems().add("¿Es calvo?");
            comboPreguntas.getItems().add("¿Tiene sombrero?");
            comboPreguntas.getItems().add("¿Tiene pelo moreno?");
            comboPreguntas.getItems().add("¿Tiene pelo rubio?");
            comboPreguntas.getItems().add("¿Tiene pelo pelirrojo?");
        }
    }

    private void pintarTablero() {
        gridPersonajes.getChildren().clear();
        int col = 0;
        int row = 0;

        // Bucle for-each clásico
        for (Personaje p : modelo.getListaPersonajes()) {
            VBox carta = crearCartaPersonaje(p);
            gridPersonajes.add(carta, col, row);
            
            // Control de columnas (4 columnas)
            col = col + 1;
            if (col == 4) { 
                col = 0; 
                row = row + 1; 
            }
        }
    }

    private VBox crearCartaPersonaje(Personaje p) {
        // Creamos la carta (Caja vertical)
        VBox carta = new VBox(8); // Espacio entre foto y nombre
        carta.getStyleClass().add("carta"); // <-- AQUI LA MAGIA: Usamos CSS
        
        carta.setPrefSize(130, 160); // Tamaño un poco más grande
        
        // --- IMAGEN ---
        ImageView imagenView = new ImageView();
        imagenView.setFitHeight(90); 
        imagenView.setFitWidth(90);  
        imagenView.setPreserveRatio(true);

        // Carga de imagen segura
        try {
            String ruta = "/imagenes/" + p.getImagenRuta();
            var stream = getClass().getResourceAsStream(ruta);
            if (stream != null) {
                imagenView.setImage(new Image(stream));
            }
        } catch (Exception e) { /* Ignorar error por ahora */ }
        // ----------------

        Label lblNombre = new Label(p.getNombre());
        lblNombre.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        // --- ESTADOS (VIVO / ELIMINADO) USANDO CSS ---
        if (p.isActivo()) {
            // Está vivo
            carta.getStyleClass().add("carta-viva"); // Añade clase CSS para hover y efectos
            imagenView.setOpacity(1.0); 
            
            // Evento de clic
            carta.setOnMouseClicked(e -> intentarAdivinar(p));
            
        } else {
            // Está eliminado
            carta.getStyleClass().add("carta-eliminada"); // Clase CSS gris
            imagenView.setOpacity(0.5); 
        }

        carta.getChildren().addAll(imagenView, lblNombre);
        return carta;
    }

    private void intentarAdivinar(Personaje seleccionado) {
        Personaje secreto = modelo.getPersonajeOculto();
        
        if (seleccionado.getNombre().equals(secreto.getNombre())) {
            mostrarAlerta("¡VICTORIA!", "¡Enhorabuena! Has descubierto a " + secreto.getNombre());
            terminarJuego(true);
        } else {
            // FALLO
            modelo.perderVida();
            actualizarVidasUI();
            
            // Mensaje limpio estilo sistema
            areaLog.appendText("\n> Fallo: No es " + seleccionado.getNombre() + ".");
            areaLog.appendText("\n  (Pierdes una vida)");
            
            seleccionado.setActivo(false);
            pintarTablero();

            if (modelo.getVidas() <= 0) {
                mostrarAlerta("GAME OVER", "Fin de la partida.\nEl personaje secreto era: " + secreto.getNombre());
                terminarJuego(false);
            }
        }
    }
    
    private void actualizarVidasUI() {
        int vidas = modelo.getVidas();
        
        // Usamos un String normal y un bucle for clásico
        String textoCorazones = "";
        
        if (vidas == 0) {
            textoCorazones = "💀";
        } else {
            for (int i = 0; i < vidas; i++) {
                textoCorazones = textoCorazones + "❤️ ";
            }
        }
        
        lblVidas.setText(textoCorazones);
    }

    private void terminarJuego(boolean victoria) {
        gridPersonajes.setDisable(true);
        btnPreguntar.setDisable(true);
        comboPreguntas.setDisable(true);
        
        String mensaje = victoria ? "¡VICTORIA!" : "DERROTA";
        areaLog.appendText("\n\n=== " + mensaje + " ===");
        areaLog.appendText("\nPulsa 'Nueva Partida' para volver a jugar.");
    }

    @FXML
    private void onBotonPreguntarClick() {
        String pregunta = comboPreguntas.getValue();
        if (pregunta == null) return;
        
        Personaje oculto = modelo.getPersonajeOculto();
        boolean respuestaReal = modelo.cumplePregunta(oculto, pregunta);
        
        String textoRespuesta = respuestaReal ? "SÍ" : "NO";
        
        // Separador visual
        areaLog.appendText("\n------------------------------");
        areaLog.appendText("\nPregunta: " + pregunta);
        areaLog.appendText("\nRespuesta: " + textoRespuesta);
        
        int descartados = 0;
        for (Personaje p : modelo.getListaPersonajes()) {
            if (p.isActivo()) {
                if (modelo.cumplePregunta(p, pregunta) != respuestaReal) {
                    p.setActivo(false);
                    descartados++;
                }
            }
        }
        
        if (descartados > 0) {
            areaLog.appendText("\n>> Se han descartado " + descartados + " personajes.");
        }
        pintarTablero();
    }
    
    @FXML
    private void onBotonReiniciarClick() {
        modelo.reiniciarJuego();
        iniciarPartidaUI();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        
        // IMPORTANTE: Ponemos el título en la cabecera para que salga la franja azul
        alert.setHeaderText(titulo); 
        alert.setContentText(mensaje);
        
        // --- MAGIA: APLICAR ESTILOS ---
        try {
            // Buscamos tu archivo CSS y se lo aplicamos a la alerta
            String css = getClass().getResource("/estilos/estilos.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(css);
            
            // Opcional: Quitar el icono por defecto de la ventana si quieres que sea más limpia
            // Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            // stage.getIcons().add(new Image(...)); // Si tuvieras un icono de juego
            
        } catch (Exception e) {
            System.out.println("Error cargando estilos de alerta: " + e.getMessage());
        }

        alert.showAndWait();
    }
    
    // --- MÉTODOS DEL MENÚ ---

    @FXML
    private void onMenuSalirClick() {
        // Cerrar la aplicación
        System.exit(0);
    }

    @FXML
    private void onMenuAyudaClick() {
        try {
            // 1. Cargar la vista de ayuda
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaAyuda.fxml"));
            Parent root = loader.load();
            
            // 2. Crear una nueva ventana (Stage)
            Stage stageAyuda = new Stage();
            stageAyuda.setTitle("Ayuda - Quién es Quién");
            stageAyuda.setScene(new Scene(root));
            
            // 3. Configurar que sea MODAL (bloquea la ventana de atrás hasta que cierres esta)
            stageAyuda.initModality(Modality.APPLICATION_MODAL);
            
            // 4. Mostrar
            stageAyuda.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la ayuda.");
        }
    }
}