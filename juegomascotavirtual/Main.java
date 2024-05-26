import componentesGraficos.EscenaMascota;
import componentesGraficos.InventarioGC;
import componentesGraficos.MenuGC;
import componentesGraficos.PanelDeEstado;
import Permanentes.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Main extends Application {

    private InventarioGC inventory;
    private EscenaMascota escenaMascota;
    private PanelDeEstado panelEstado;
    private MenuGC menu;


    public void start(Stage primaryStage) throws FileNotFoundException {
        Mascota.Initialize("Roger");
        Mascota.printIndicators();


        inventory = new InventarioGC();
        escenaMascota = new EscenaMascota();
        panelEstado = new PanelDeEstado("POU 2");
        menu = new MenuGC();


        BorderPane root = new BorderPane();



       
        // Display
        root.setLeft(panelEstado);
        root.setTop(menu);
        root.setCenter(escenaMascota);        
        root.setBottom(inventory);

        double INTERVAL = 0.5;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(INTERVAL), event -> {
        panelEstado.setUpdate();
        Mascota.getInstance().GetOld();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        BorderPane.setAlignment(inventory, Pos.TOP_RIGHT);
        primaryStage.setScene(new Scene(root, 1175,900));
        primaryStage.show();


        

    }
    public static void main(String[] args) {
        launch(args);
    }
}
