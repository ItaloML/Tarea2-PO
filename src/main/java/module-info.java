module com.example.tarea21 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.tarea21 to javafx.fxml;
    exports com.example.tarea21;
}