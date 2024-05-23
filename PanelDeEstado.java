package com.example.juegomascotavirtual;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PanelDeEstado extends VBox {

    private final AnchorPane datosMascota = new AnchorPane();
    private final ProgressBar healthBar = createProgressBar();
    private final ProgressBar energyBar = createProgressBar();
    private final ProgressBar happinessBar = createProgressBar();


    private ProgressBar createProgressBar() {
        ProgressBar pb = new ProgressBar();
        pb.setPrefSize(450, 45);
        return pb;
    }


    public PanelDeEstado(String name) {
        Text nameText = new Text("Nombre:\t\t" + name + "\n\nEdad:\t\t1.50");
        nameText.setFont(Font.font("Arial", 20));
        datosMascota.getChildren().add(nameText);
        AnchorPane.setTopAnchor(nameText, 10.0);
        AnchorPane.setBottomAnchor(nameText, 10.0);
        AnchorPane.setLeftAnchor(nameText, 45.0);

        /////////////////////////////////////////////////////
        VBox panelAtributos = new VBox();
        panelAtributos.setPrefWidth(400);
        panelAtributos.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panelAtributos.setAlignment(Pos.CENTER);


        Text healthTitle = new Text("\nSalud");
        healthTitle.setFont(Font.font("Arial", 24));
        healthTitle.setFill(Color.RED);

        Text energyTitle = new Text("\n\nEnergía");
        energyTitle.setFont(Font.font("Arial", 24));
        energyTitle.setFill(Color.GREEN);

        Text happinessTitle = new Text("\n\nFelicidad");
        happinessTitle.setFont(Font.font("Arial", 24));
        happinessTitle.setFill(Color.BLUE);

        // Valores hardcodeados para las barras. Luego creo que habría que hacer una "Property"
        // y hacer un binding con los atributos reales de la mascota
        healthBar.setProgress(0.25F);
        energyBar.setProgress(0.55F);
        happinessBar.setProgress(0.80F);

        // Añadirlos al VBox de los atributos
        panelAtributos.getChildren().addAll(healthTitle, healthBar, energyTitle, energyBar, happinessTitle, happinessBar);



        ///////////////////////////////////////////////////////////////
        VBox estadoMascota = new VBox();
        estadoMascota.setAlignment(Pos.CENTER);
        Text estadoTitulo = new Text("Estado\n\n\n");
        estadoTitulo.setFont(Font.font("Arial", 24));

        Text estado = new Text("BASADO");
        estado.setFont(Font.font("Arial", 48));
        estadoMascota.getChildren().addAll(estadoTitulo, estado);



        getChildren().addAll(datosMascota, panelAtributos, estadoMascota);
        setPrefWidth(400);
        setSpacing(25);
    }

}
