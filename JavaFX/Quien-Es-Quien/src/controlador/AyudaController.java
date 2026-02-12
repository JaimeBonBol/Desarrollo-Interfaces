package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class AyudaController {

    @FXML private Button btnCerrar;
    @FXML private VBox panelContenido; // El área derecha donde escribiremos

    @FXML
    public void initialize() {
        // Cargar la introducción por defecto al abrir
        mostrarIntroduccion();
    }

    // --- MÉTODOS DE NAVEGACIÓN ---

    @FXML
    private void mostrarIntroduccion() {
        actualizarContenido("Introducción", 
            "Bienvenido a ¿Quién es Quién? edición JavaFX.\n\n" +
            "Este es un juego de lógica y deducción clásico diseñado para poner a prueba tu capacidad de descarte. " +
            "Te enfrentarás a una inteligencia artificial (la CPU) que ha seleccionado un personaje secreto.\n\n" +
            "Tu misión es descubrir quién es ese personaje haciendo las preguntas correctas antes de que se agoten tus oportunidades.");
    }

    @FXML
    private void mostrarObjetivo() {
        actualizarContenido("Objetivo del Juego", 
            "El objetivo principal es identificar al personaje secreto oculto entre las 12 cartas del tablero.\n\n" +
            "CONDICIONES DE VICTORIA:\n" +
            "• Debes hacer clic sobre la carta del personaje correcto.\n\n" +
            "CONDICIONES DE DERROTA:\n" +
            "• Si te quedas sin vidas (corazones), pierdes la partida inmediatamente.\n" +
            "• Cada vez que intentas adivinar un personaje y fallas, pierdes una vida.");
    }

    @FXML
    private void mostrarInterfaz() {
        actualizarContenido("Interfaz y Vidas", 
            "1. EL TABLERO:\n" +
            "En el centro verás 12 cartas. Las cartas iluminadas son los 'sospechosos' activos. " +
            "Las cartas grises o tachadas son personajes que ya has descartado.\n\n" +
            "2. BARRA DE VIDAS (Arriba):\n" +
            "Empiezas con 3 corazones (❤️❤️❤️). Cuídalos bien.\n\n" +
            "3. PANEL DE CONTROL (Abajo):\n" +
            "Aquí encontrarás el selector de preguntas y el botón para reiniciar la partida en cualquier momento.");
    }

    @FXML
    private void mostrarComoJugar() {
        actualizarContenido("Cómo Jugar", 
            "Sigue estos pasos para ganar:\n\n" +
            "PASO 1: ANALIZA\n" +
            "Mira los personajes activos. Busca rasgos comunes (¿Muchos llevan sombrero? ¿La mayoría son mujeres?).\n\n" +
            "PASO 2: PREGUNTA\n" +
            "Usa el desplegable inferior para elegir una característica (ej: '¿Tiene gafas?'). Pulsa el botón verde 'PREGUNTAR'.\n\n" +
            "PASO 3: FILTRA\n" +
            "La máquina te responderá SÍ o NO. El juego eliminará automáticamente a los personajes que no coincidan.\n\n" +
            "PASO 4: ADIVINA\n" +
            "Cuando creas saber quién es, haz clic en su foto. ¡Cuidado! Si fallas, perderás una vida.");
    }
    
    @FXML
    private void mostrarAcercaDe() {
        actualizarContenido("Acerca de", 
            "Práctica de Diseño de Interfaces (DIN).\n" +
            "Desarrollado con Java y JavaFX.\n\n" +
            "Versión: 1.0\n" +
            "Autor: Jaime Bonilla\n" +
            "Año: 2026\n\n" +
            "Gracias por jugar.");
    }

    // --- LÓGICA INTERNA ---

    // Método auxiliar para limpiar y rellenar el panel derecho
    private void actualizarContenido(String titulo, String cuerpo) {
        panelContenido.getChildren().clear(); // Limpiamos lo anterior

        // 1. Crear Título
        Label lblTitulo = new Label(titulo);
        lblTitulo.getStyleClass().add("ayuda-titulo-seccion");
        lblTitulo.setWrapText(true);

        // 2. Crear Cuerpo de texto
        Text txtCuerpo = new Text(cuerpo);
        txtCuerpo.getStyleClass().add("ayuda-texto-cuerpo");
        
        // Usamos TextFlow para que el texto se ajuste al ancho de la ventana
        TextFlow flow = new TextFlow(txtCuerpo);
        
        // 3. Añadir al panel
        panelContenido.getChildren().addAll(lblTitulo, flow);
    }

    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }
}