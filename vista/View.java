package juegomascotavirtual.vista;

import javafx.scene.layout.BorderPane;

public class View extends BorderPane {
    private final MenuGC menu;
    private final EscenaMascota escenaMascota = new EscenaMascota();
    private final PanelDeEstado panelDeEstado;
    private final InventarioGC inventario = new InventarioGC();

    public View(String name) {
        menu = new MenuGC();
        panelDeEstado = new PanelDeEstado(name);
        setTop(menu);
        setCenter(escenaMascota);
        setLeft(panelDeEstado);
        setBottom(inventario.getInventory());
    }

    public MenuGC getMenu() {return menu;}
    public InventarioGC getInventario() {return inventario;}
    public PanelDeEstado getPanelDeEstado() {return panelDeEstado;}
}

