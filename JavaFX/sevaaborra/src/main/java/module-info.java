module com.mycompany.sevaaborra {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.sevaaborra to javafx.fxml;
    exports com.mycompany.sevaaborra;
}
