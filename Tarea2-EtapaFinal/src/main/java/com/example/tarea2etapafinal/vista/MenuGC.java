package com.example.tarea2etapafinal.vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuGC extends MenuBar {

    private final MenuItem iniciar =  new MenuItem("Iniciar");
    private final MenuItem reiniciar = new MenuItem("Reiniciar");
    private final MenuItem salir = new MenuItem("Salir");
    private final MenuItem apagarLuz = new MenuItem("Apagar luz");
    private final MenuItem encenderLuz = new MenuItem("Encender luz");
    private final MenuItem acercaDe = new MenuItem("Acerca de");

    public MenuGC() {
        // Creación del menú de inicio
        Menu inicio = new Menu("Inicio");
        inicio.getItems().addAll(iniciar, reiniciar, salir);

        // Creación del menú de acciones
        Menu acciones = new Menu("Acciones");
        acciones.getItems().addAll(apagarLuz, encenderLuz);

        // Creación del menú de ayuda
        Menu help = new Menu("Help");
        help.getItems().addAll(acercaDe);

        // Añadir a la barra completa
        getMenus().addAll(inicio, acciones, help);
    }

    // Getters:
    public MenuItem getIniciar() {return iniciar;}
    public MenuItem getReiniciar() {return reiniciar;}
    public MenuItem getSalir() {return salir;}
    public MenuItem getEncenderLuz() {return encenderLuz;}
    public MenuItem getApagarLuz() {return apagarLuz;}
    public MenuItem getAcercaDe() {return acercaDe;}
}
