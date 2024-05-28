package juegomascotavirtual.controlador;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import juegomascotavirtual.modelo.*;
import juegomascotavirtual.vista.MenuGC;
import juegomascotavirtual.vista.View;

import java.util.ArrayList;
import java.util.Scanner;


public class Controlador {
    ArrayList<Item >inventarioOriginal = new ArrayList<Item>();
    private Mascota mascota;
    private View view;
    private final Timeline time;


    public Controlador(Scanner in) {
        readConfiguration(in);
        view = new View(mascota.getName());
        double INTERVAL = 0.5;
        time = new Timeline(new KeyFrame(Duration.seconds(INTERVAL), _-> {
            mascota.GetOld();
        }));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
        time.pause();
        view.getInventario().intializeInventarioGC(inventarioOriginal);
        attachItemsEventHandlers();
        bindPetProperties();
        attachMenuEventHandlers();
    }


    private void readConfiguration(Scanner in) {
        // Creación de mascota
        String nombre_mascota = in.nextLine();
        this.mascota = new Mascota(nombre_mascota);

        // Llenando del inventario de la mascota
        while (in.hasNextLine()) {
            String linea = in.nextLine();
            String[] item_csv = linea.split(";");
            int id = Integer.parseInt(item_csv[0]);
            String tipoItem = item_csv[1];
            String nombreItem = item_csv[2];
            if (tipoItem.equals("Juguete")) {
                String rutaImagen = "/" + item_csv[3];
                inventarioOriginal.add(new Juguete(nombreItem, id, rutaImagen));
            } else if (tipoItem.equals("Alimento")) {
                int cantidad = Integer.parseInt(item_csv[3]);
                inventarioOriginal.add(new Comida(nombreItem, id, cantidad));
            } else {
                int cantidad = Integer.parseInt(item_csv[3]);
                inventarioOriginal.add(new Medicina(nombreItem, id, cantidad));
            }
        }
    }


    public View getView() {
        return view;
    }

    private void restart() {
        time.pause();
        mascota.reset();
        view.getInventario().intializeInventarioGC(inventarioOriginal);
    }



    private void attachItemsEventHandlers() {
        view.getInventario().attachEventHandlers(mascota);
    }

    private void bindPetProperties() {
        view.getPanelDeEstado().getHappinessBar().progressProperty().bind(mascota.getHappiness().divide(100.0).asObject());
        view.getPanelDeEstado().getEnergyBar().progressProperty().bind(mascota.getEnergy().divide(100.0).asObject());
        view.getPanelDeEstado().getHealthBar().progressProperty().bind(mascota.getHealth().divide(100.0).asObject());
    }



    private void attachMenuEventHandlers() {
        MenuGC menu = view.getMenu();

        menu.getIniciar().setOnAction(_->{
            if (time.getStatus() == Animation.Status.PAUSED) time.play();
        });

        menu.getSalir().setOnAction(_->{
            System.exit(0);
        });

        menu.getReiniciar().setOnAction(_->restart());
    }
}
