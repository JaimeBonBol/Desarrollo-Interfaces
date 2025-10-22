/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Alimento;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaAlimentosController implements Initializable {

    @FXML
    private ImageView iconHome;
    @FXML
    private ImageView iconSettings;
    @FXML
    private ImageView iconDish;
    @FXML
    private ImageView iconPowerOff;
    @FXML
    private TableView<modelo.Alimento> tablaAlimentos;
    @FXML
    private TableColumn<modelo.Alimento, String> colNombre;
    @FXML
    private TableColumn<modelo.Alimento, Double> colCantidad;
    @FXML
    private TableColumn<modelo.Alimento, String> colUnidad;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Label labelMensaje;
    
    private String rutaArchivoAlimentos = "src/fichero/alimentos.txt";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Vincular las columnas de la tabla con los atributos de la clase Alimento
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colUnidad.setCellValueFactory(new PropertyValueFactory<>("unidad"));
        
        // Enlazar la tabla con la lista observable
        tablaAlimentos.setItems(modelo.DatosCompartidos.getAlimentos());
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
    private void eliminarAlimento(MouseEvent event) {
        
        // Obtener el alimento seleccionado de la tabla
        modelo.Alimento alimento = tablaAlimentos.getSelectionModel().getSelectedItem();
        
        if (alimento != null) {
            // Se elimina y se llama al metodo de escribir en el txt para que lo actualice
            modelo.DatosCompartidos.getAlimentos().remove(alimento);
            modelo.DatosCompartidos.guardarAlimentosFichero(rutaArchivoAlimentos);
            
            labelMensaje.setStyle("-fx-text-fill: green;");
            labelMensaje.setText(alimento.getNombre() + " eliminado con éxito");

        }else{
            labelMensaje.setStyle("-fx-text-fill: red;");
            labelMensaje.setText("Debes seleccionar un alimento");
        }
    }

    @FXML
    private void cambiarVistaAgregarAlimento(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaAgregarAlimento.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) btnAgregar.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("AGREGAR ALIMENTO");         
    }

    @FXML
    private void cambiarVistaModificarAlimento(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaModificarAlimento.fxml"));

        Parent root = loader.load();
        Scene escena = new Scene(root);

        // Obtener el Stage actual desde el botón
        Stage stage = (Stage) btnAgregar.getScene().getWindow();

        // Reemplazar la escena actual
        stage.setScene(escena);
        stage.setTitle("MODIFICAR ALIMENTO"); 
    }
    
}
