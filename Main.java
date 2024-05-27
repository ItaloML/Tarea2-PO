import Interfaz.EscenaMascota;
import Interfaz.PanelDeEstado;
import Interfaz.InventarioGC;
import Interfaz.MenuGC;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    public void start(Stage primaryStage) throws FileNotFoundException {
        // Crear instancias de las clases de la interfaz
        EscenaMascota escenaMascota = new EscenaMascota();
        MenuGC menu = new MenuGC();
        InventarioGC inventario = new InventarioGC();
        PanelDeEstado panelDeEstado = new PanelDeEstado("Pou");

        // Funcionalidades del Menu
        menu.getApagarLuz().setOnAction(event -> escenaMascota.apagarLuz());
        menu.getEncenderLuz().setOnAction(event -> escenaMascota.encenderLuz());

        // Crear BorderPane y añadir los elementos de la ventana
        BorderPane root = new BorderPane();
        root.setCenter(escenaMascota);
        root.setTop(menu);
        root.setLeft(panelDeEstado);

        // Mover a la derecha el inventario. Es solamente una cuestion estetica
        HBox bottomContainer = new HBox();
        bottomContainer.setPadding(new Insets(0, 0, 0, 50)); // Ajusta el valor según sea necesario
        bottomContainer.getChildren().add(inventario);
        bottomContainer.setAlignment(Pos.BOTTOM_RIGHT); // Alinea el inventario a la derecha

        root.setBottom(bottomContainer);

        // Configurar la escena y mostrar la ventana
        primaryStage.setScene(new Scene(root, 1175, 900));
        primaryStage.setTitle("Pou 2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
