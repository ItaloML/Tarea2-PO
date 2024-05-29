package com.example.tarea2etapafinal.vista;



import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.layout.StackPane;
import java.util.Objects;


public class EscenaMascota extends StackPane {
    private final Image fondo; //Cada atributo sirve para manejar con mayor facilidad los elementos que contemplan la escena
    private final Image pouImage;
    private final ImageView fondoView;
    private final ImageView pouView;
    private final ColorAdjust colorAdjust;
    private boolean dia; // Atributo que usamos para saber si es de dia



    public EscenaMascota() {
        // Cargar las imágenes desde el ClassPath (./target/classes)
        fondo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/background/background1.jpg")));
        pouImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pet/pou.png")));

        // Crear ImageViews
        fondoView = new ImageView(fondo);
        fondoView.setFitHeight(600);
        fondoView.setFitWidth(600);

        pouView = new ImageView(pouImage);
        pouView.setFitHeight(200);
        pouView.setFitWidth(200);

        // Inicializar ColorAdjust para efectos
        colorAdjust = new ColorAdjust();
        fondoView.setEffect(colorAdjust);
        pouView.setEffect(colorAdjust);

        // Añadir ImageViews al StackPane
        getChildren().addAll(fondoView, pouView);

        // Alinear y bajar la posición del Pou
        StackPane.setAlignment(pouView, Pos.CENTER);
        pouView.setTranslateY(150);

        // Estado inicial: es de día
        dia = true;
    }

    // Método para apagar la luz (oscurecer el fondo)
    public void apagarLuz() {
        if (dia) {
            dia = false;
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(colorAdjust.brightnessProperty(), 0)),
                    new KeyFrame(new Duration(1000), new KeyValue(colorAdjust.brightnessProperty(), -0.7))
            );
            timeline.play();
        }
    }

    // Método para encender la luz (aclarar el fondo)
    public void encenderLuz() {
        if (!dia) {
            dia = true;
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(colorAdjust.brightnessProperty(), -0.7)),
                    new KeyFrame(new Duration(1000), new KeyValue(colorAdjust.brightnessProperty(), 0))
            );
            timeline.play();
        }
    }
}
