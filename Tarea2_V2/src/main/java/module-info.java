module juegomascotavirtual {
    requires javafx.controls;
    requires javafx.fxml;


    opens juegomascotavirtual to javafx.fxml;
    exports juegomascotavirtual;
}