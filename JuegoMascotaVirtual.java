package com.example.juegomascotavirtual;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class JuegoMascotaVirtual extends Application {

    private InventarioGC inventory;
    private EscenaMascota escenaMascota;
    private PanelDeEstado panelEstado;
    private MenuGC menu;


    public void start(Stage primaryStage) throws FileNotFoundException {
        inventory = new InventarioGC();
        escenaMascota = new EscenaMascota();
        panelEstado = new PanelDeEstado("POU 2");
        menu = new MenuGC();


        BorderPane root = new BorderPane();



        // Display
        root.setTop(menu);
        root.setCenter(escenaMascota);
        root.setLeft(panelEstado);
        root.setBottom(inventory);
        BorderPane.setAlignment(inventory, Pos.TOP_RIGHT);
        primaryStage.setScene(new Scene(root, 1175,900));
        primaryStage.show();
    }
}
