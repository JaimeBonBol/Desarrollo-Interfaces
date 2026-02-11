import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Cargamos el FXML desde la ruta correcta
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaJuego.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setTitle("¿Quién es Quién? - Práctica DIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}