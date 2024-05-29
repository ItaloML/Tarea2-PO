module com.example.tarea2etapafinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea2etapafinal to javafx.fxml;
    exports com.example.tarea2etapafinal;
}