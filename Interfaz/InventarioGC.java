package Interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InventarioGC extends VBox {

    public InventarioGC() {
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        setPrefWidth(800);
        setMaxWidth(800);
        setAlignment(Pos.TOP_CENTER);

        // Creación del título "Inventario"
        Label inventoryTitle = new Label("Inventario");
        inventoryTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        inventoryTitle.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(inventoryTitle, Priority.NEVER);
        inventoryTitle.setAlignment(Pos.TOP_CENTER);

        // Creación de las dos líneas separadoras
        Line lineAbove = new Line(0, 0, 800, 0);
        Line lineBelow = new Line(0, 0, 800, 0);
        lineAbove.setStroke(Color.BLACK);
        lineAbove.setStrokeWidth(2);
        lineBelow.setStroke(Color.BLACK);
        lineBelow.setStrokeWidth(2);

        // Creación del panel inventario
        HBox panelInventario = new HBox();
        HBox.setHgrow(panelInventario, Priority.ALWAYS);
        panelInventario.setSpacing(10);
        panelInventario.setPadding(new Insets(10, 10, 10, 10));
        panelInventario.setPrefWidth(900);
        panelInventario.setMaxWidth(900);
        panelInventario.setPrefHeight(150);
        panelInventario.setMaxHeight(150);

        // Creación de los paneles de Alimentos, Medicinas y Juguetes sin interacción
        VBox alimentosPanel = createSimplePanel("Alimentos");
        VBox medicinasPanel = createSimplePanel("Medicinas");
        VBox juguetesPanel = createSimplePanel("Juguetes");

        // Añadir estos 3 componentes al panel del Inventario
        panelInventario.getChildren().addAll(alimentosPanel, medicinasPanel, juguetesPanel);

        // Añadir los componentes a la main VBox
        this.getChildren().addAll(lineAbove, inventoryTitle, lineBelow, panelInventario);
    }

    private VBox createSimplePanel(String title) {
        VBox panel = new VBox();
        panel.setMaxWidth(300);
        panel.setPrefWidth(300);
        panel.setMaxHeight(150);
        panel.setPrefHeight(150);
        panel.setSpacing(10);
        panel.setAlignment(Pos.TOP_CENTER);

        // Título
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(titleLabel, Priority.NEVER);

        // Panel vacío que simula contenido
        FlowPane content = new FlowPane();
        content.setHgap(10);
        content.setVgap(5);
        content.setPrefSize(300, 120);
        content.setAlignment(Pos.CENTER);
        content.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        panel.getChildren().addAll(titleLabel, content);
        return panel;
    }
}
