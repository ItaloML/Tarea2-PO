package Interfaz;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuGC extends MenuBar {
    private final MenuItem apagarLuz;
    private final MenuItem encenderLuz;

    public MenuGC() {
        Menu inicio = new Menu("Inicio");
        MenuItem iniciar = new MenuItem("Iniciar");
        MenuItem reiniciar = new MenuItem("Reiniciar");
        MenuItem salir = new MenuItem("Salir");
        inicio.getItems().addAll(iniciar, reiniciar, salir);

        Menu acciones = new Menu("Acciones");
        apagarLuz = new MenuItem("Apagar luz");
        encenderLuz = new MenuItem("Encender luz");
        acciones.getItems().addAll(apagarLuz, encenderLuz);

        Menu help = new Menu("Help");
        MenuItem acercaDe = new MenuItem("Acerca de");
        help.getItems().addAll(acercaDe);

        getMenus().addAll(inicio, acciones, help);
    }

    public MenuItem getApagarLuz() {
        return apagarLuz;
    }

    public MenuItem getEncenderLuz() {
        return encenderLuz;
    }
}
