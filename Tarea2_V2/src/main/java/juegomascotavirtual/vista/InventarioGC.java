package juegomascotavirtual.vista;

import javafx.event.ActionEvent;
import juegomascotavirtual.modelo.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;


public class InventarioGC extends VBox {
    private final ItemPanel Alimentos = new ItemPanel("Alimentos");
    private final ItemPanel Medicinas = new ItemPanel("Medicinas");
    private final ToyPanel Juguetes = new ToyPanel();


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
        panelInventario.setPrefWidth(900);
        panelInventario.setMaxWidth(900);
        panelInventario.setPrefHeight(150);
        panelInventario.setMaxHeight(150);


        // Se añaden estos 3 componentes al panel del Inventario y se espedifica su tamaño (que será fijo).
        panelInventario.getChildren().addAll(Alimentos, Medicinas, Juguetes);

        // Se añaden los componentes a la main VBox
        this.getChildren().addAll(lineAbove, inventoryTitle, lineBelow, panelInventario);
    }

    public void intializeInventarioGC(ArrayList<Item> invMascota) {
        for (int i = 0; i < invMascota.size(); i++) {
            Item aux = invMascota.get(i);
            switch (aux.getClass().getSimpleName()) {
                case "Comida" -> Alimentos.add(new ItemButton(Comida.copyOf((Comida) aux)));
                case "Medicina" -> Medicinas.add(new ItemButton(Medicina.copyOf((Medicina) aux)));
                case "Juguete" ->  Juguetes.addToy(Juguete.copyOf((Juguete) aux));
                default -> throw new IllegalStateException("Unexpected value: " + aux.getClass().getSimpleName());
            }
        }
    }

    public HBox getInventory(){
        HBox container = new HBox();
        container.setPadding(new Insets(0, 0, 0, 50)); // Ajusta el valor según sea necesario
        container.getChildren().add(this);
        container.setAlignment(Pos.BOTTOM_RIGHT); // Alinea el inventario a la derecha
        return container;
    }

    public void disableButtons() {
        Alimentos.disableButtons();
        Medicinas.disableButtons();
        Juguetes.disableButtons();
    }
    public void enableButtons() {
        Alimentos.enableButtons();
        Medicinas.enableButtons();
        Juguetes.enableButtons();
    }


    public void attachEventHandlers(Mascota mascota) {
        Alimentos.attachEventHandlers(mascota);
        Medicinas.attachEventHandlers(mascota);
        Juguetes.attachEventHandlers(mascota);
    }

    public void deleteAndDettachEventHandlers() {
        Alimentos.deleteAndDettachEventHandlers();
        Medicinas.deleteAndDettachEventHandlers();
        Juguetes.deleteAndDettachEventHandlers();
    }
}


class ToyPanel extends VBox {
    private final FlowPane toyPanel = new FlowPane();
    private final ArrayList<ToyButton> toys = new ArrayList<>();

    public ToyPanel() {
        setMaxWidth(300);
        setPrefWidth(300);
        setMaxHeight(150);
        setPrefHeight(150);
        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);

        // Título
        Label title = new Label("Juguetes");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        title.setAlignment(Pos.CENTER);
        title.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(title, Priority.NEVER);

        // Flow Pane de los botones.
        toyPanel.setHgap(10);
        toyPanel.setVgap(5);
        toyPanel.setPrefSize(300, 120);
        toyPanel.setAlignment(Pos.CENTER);

        getChildren().addAll(title, toyPanel);
    }


    public void addToy(Juguete toy) {
        ToyButton toyButton = new ToyButton(toy);
        toyPanel.getChildren().add(toyButton);
        toys.add(toyButton);

    }

    public void enableButtons() {
        for (ToyButton toy : toys) {
            toy.setDisable(false);
        }
    }

    public void disableButtons() {
        for (ToyButton toy : toys) {
            toy.setDisable(true);
        }
    }

    public void attachEventHandlers(Mascota mascota) {
        for (ToyButton toy : toys) {
            toy.setOnAction(_ -> {
                toy.getItem().actionItem(mascota);
            });
        }
    }

    public void deleteAndDettachEventHandlers() {
        for (ToyButton toy : toys) {
            toy.removeEventHandler(ActionEvent.ACTION, toy.getOnAction());
        }
        toyPanel.getChildren().clear();
    }
}



class ItemPanel extends VBox {
    private final GridPane itemPanel = new GridPane();
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



        itemPanel.setAlignment(Pos.TOP_CENTER);
        itemPanel.setPrefSize(300,120);

        HBox cell1 = createCell();
        HBox cell2 = createCell();
        HBox cell3 = createCell();
        HBox cell4 = createCell();
        HBox cell5 = createCell();
        HBox cell6 = createCell();

        itemPanel.add(cell1, 0,0);
        itemPanel.add(cell2, 1,0);
        itemPanel.add(cell3, 0,1);
        itemPanel.add(cell4,1,1);
        itemPanel.add(cell5,0,2);
        itemPanel.add(cell6,1,2);

        this.getChildren().addAll(titleLabel, itemPanel);
        this.setPrefWidth(itemPanel.getPrefWidth());
        this.setMaxWidth(itemPanel.getPrefWidth());
    }

    private HBox createCell() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(2));
        hBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        hBox.setPrefSize(160, 40);
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
        stockLabel.setPrefSize(40,40);
        cell.getChildren().addAll(stockLabel, item);
    }

    public void remove(ItemButton depletedItem) {
        for (ItemButton item : items) {
            HBox parent = (HBox) item.getParent();
            parent.getChildren().clear();
        }
        items.remove(depletedItem);
        depletedItem.removeEventHandler(ActionEvent.ACTION, depletedItem.getOnAction());
        for (ItemButton item : items) {add(item);}
    }

    public void enableButtons() {
        for (ItemButton item : items) {
            item.setDisable(false);
        }
    }

    public void disableButtons() {
        for (ItemButton item : items) {
            item.setDisable(true);
        }
    }

    public void attachEventHandlers(Mascota mascota) {
        for (ItemButton item : items) {
            item.setOnAction(_ -> {
                item.getItem().actionItem(mascota);
                if (item.getStock() == 0) {
                    remove(item);
                } else {
                    add(item);
                }
            });
        }
    }

    public void deleteAndDettachEventHandlers() {
        for (ItemButton item : items) {
            item.removeEventHandler(ActionEvent.ACTION, item.getOnAction());
            HBox parentCell = (HBox) item.getParent();
            parentCell.getChildren().clear();
        }
        items.clear();
    }
}











class ItemButton extends Button {
    protected Item item;

    public ItemButton(Item item) {
        this.item = item;
        setText(item.getName());
        setPrefSize(120,35);
    }


    public Item getItem() {return item;}
    public int getStock() {return item.getStock();}
}



class ToyButton extends Button {
    protected Juguete item;

    ToyButton(Juguete toy) {
        this.item = toy;
        setText("");
        setPrefSize(120,35);

        ImageView imView = toy.getImageView();
        imView.setPreserveRatio(true);
        imView.setFitHeight(35);
        imView.setFitWidth(120);
        setGraphic(imView);
    }

    public Item getItem() {return item;}
}
