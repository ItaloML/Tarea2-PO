package com.example.tarea2etapafinal.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.example.tarea2etapafinal.Main;

import java.util.Objects;

public class Juguete extends Item{
    private final String imageLocation;

    //Constructor del Objeto Item Juguete
    public Juguete(String name, int id, String imageLocation) {
        super(name, id, -1);
        // La imagen se busca en el ClassPath, que es la carpeta ./target/classes
        this.imageLocation = imageLocation;
    }


    public static Juguete copyOf(Juguete other) {
        return new Juguete(other.name, other.id, other.imageLocation);
    }

    @Override
    public void actionItem(Mascota mascota){
        int current_happiness = mascota.getHappiness().get();
        mascota.setHappiness(current_happiness+30);
    }

    public ImageView getImageView() {
        return new ImageView(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(imageLocation))));
    }

}