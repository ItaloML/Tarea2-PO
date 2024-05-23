package com.example.juegomascotavirtual;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;


public class InventarioGC extends VBox {

    public static ItemPanel Alimentos = new ItemPanel("Alimentos");
    public static ItemPanel Medicinas = new ItemPanel("Medicinas");
    public static VBox Juguetes = new VBox();

    public InventarioGC() {
        setSpacing(5);
        setPadding(new Insets(10,10,10,10));
        setPrefWidth(800);
        setMaxWidth(800);
        setAlignment(Pos.TOP_CENTER);

        // Creacíón del título "Inventario"
        Label inventoryTitle = new Label("Inventario");
        inventoryTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        inventoryTitle.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(inventoryTitle,Priority.NEVER);
        inventoryTitle.setAlignment(Pos.TOP_CENTER);

        // Creación de las dos líneas separadoras
        Line lineAbove = new Line(0, 0, 800, 0);
        Line lineBelow = new Line(0, 0, 800, 0);
        lineAbove.setStroke(Color.BLACK);
        lineAbove.setStrokeWidth(2);
        lineBelow.setStroke(Color.BLACK);
        lineBelow.setStrokeWidth(2);

        // Creación del panel inventario. Este será una HBox que contendrá los tres sub-paneles (Alimentos, Medicinas y Juguetes)
        HBox panelInventario = new HBox();
        HBox.setHgrow(panelInventario, javafx.scene.layout.Priority.ALWAYS);
        panelInventario.setSpacing(10);
        panelInventario.setPadding(new Insets(10,10,10,10));
        panelInventario.setPrefSize(900,780);

        // Los paneles de Alimentos y Medicina son iguales. Se crean con un método dedicado y se añaden sus elementos con otros métodos.
        // Más detalles en la definición de dichos métodos.

        ItemButton alimento1 = new ItemButton(10,"Leche",6);
        ItemButton alimento2 = new ItemButton(11,"Arroz",2);
        ItemButton alimento3 = new ItemButton(12,"Carne",3);
        Alimentos.add(alimento1);
        Alimentos.add(alimento2);
        Alimentos.add(alimento3);



        ItemButton med1 = new ItemButton(1,"Parecetamol",2);
        ItemButton med2 = new ItemButton(2,"Jarabe",4);
        Medicinas.add(med1);
        Medicinas.add(med2);

        // El panel de los juguetes es diferente y se crea con otro método dedicado
        Juguetes = createToyPanel();

        // Se añaden estos 3 componentes al panel del Inventario y se espedifica su tamaño (que será fijo).
        panelInventario.getChildren().addAll(Alimentos, Medicinas, Juguetes);
        panelInventario.setPrefWidth(800);
        panelInventario.setMaxWidth(800);
        panelInventario.setPrefHeight(150);
        panelInventario.setMaxHeight(150);

        // Se añaden los componentes a la main VBox
        this.getChildren().addAll(lineAbove, inventoryTitle, lineBelow, panelInventario);
    }



    private VBox createToyPanel() {
        VBox tablaJuguetes = new VBox();
        tablaJuguetes.setMaxWidth(300);
        tablaJuguetes.setMaxHeight(780);
        tablaJuguetes.setAlignment(Pos.TOP_CENTER);
        tablaJuguetes.setSpacing(40);

        Label title = new Label("Juguetes");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        title.setAlignment(Pos.CENTER);
        title.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(title,Priority.NEVER);

        ButtonBar buttons = new ButtonBar();
        Button toy1 = new Button("Pelota");
        Button toy2 = new Button("Kong");

        buttons.getButtons().addAll(toy1, toy2);

        tablaJuguetes.getChildren().addAll(title, buttons);
        return tablaJuguetes;
    }
}




class ItemPanel extends VBox {
    private final GridPane itemPanel;
    private final ArrayList<ItemButton> items = new ArrayList<>();

    ItemPanel(String title) {
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        titleLabel.setPrefHeight(15);
        titleLabel.setAlignment(Pos.TOP_CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(titleLabel,Priority.NEVER);


        GridPane table = new GridPane();
        table.setAlignment(Pos.TOP_CENTER);
        table.setPrefSize(300,120);

        HBox cell1 = createCell();
        HBox cell2 = createCell();
        HBox cell3 = createCell();
        HBox cell4 = createCell();
        HBox cell5 = createCell();
        HBox cell6 = createCell();

        table.add(cell1, 0,0);
        table.add(cell2, 1,0);
        table.add(cell3, 0,1);
        table.add(cell4,1,1);
        table.add(cell5,0,2);
        table.add(cell6,1,2);

        this.getChildren().addAll(titleLabel, table);
        this.setPrefWidth(table.getPrefWidth());
        this.setMaxWidth(table.getPrefWidth());

        this.itemPanel = table;
    }

    private HBox createCell() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(2));
        hBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        hBox.setPrefSize(150, 40);
        return hBox;
    }

    public void add(ItemButton item) {
        int idx;
        if (items.contains(item)) {
            idx = items.indexOf(item);
        } else {
            idx = items.size();
            items.add(item);
        }

        HBox cell = (HBox) itemPanel.getChildren().get(idx);
        if (!cell.getChildren().isEmpty()) cell.getChildren().clear();

        Label stockLabel = new Label(Integer.toString(item.getStock()));
        stockLabel.setAlignment(Pos.CENTER);
        stockLabel.setPrefSize(30,40);
        item.setText(item.getItemName());
        item.setPrefSize(120,35);
        cell.getChildren().addAll(stockLabel, item);
    }

    public void remove(ItemButton depletedItem) {
        for (ItemButton item : items) {
            HBox parent = (HBox) item.getParent();
            parent.getChildren().clear();
        }
        items.remove(depletedItem);
        for (ItemButton item : items) {add(item);}
    }
}





class ItemButton extends Button {
    private final int ID;
    private int stock;
    private final String itemName;

    ItemButton(int ID, String itemName, int stock) {
        this.ID = ID;
        this.stock = stock;
        this.itemName = itemName;
        this.setOnAction(_->this.action());
    }


    public int getID() {
        return ID;
    }

    public int getStock() {
        return stock;
    }

    public String getItemName() {
        return itemName;
    }

    public void action() {
        HBox parent = (HBox) this.getParent();
        GridPane grandparent = (GridPane) parent.getParent();
        ItemPanel grandgrandparent = (ItemPanel) grandparent.getParent();

        // Checking if the grandparent is not null
        if (grandgrandparent != null) {
            stock = stock - 1;
            if (stock == 0) {grandgrandparent.remove(this);}
            else {grandgrandparent.add(this);}
        }
    }
}


