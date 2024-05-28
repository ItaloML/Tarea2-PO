package juegomascotavirtual.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import juegomascotavirtual.Main;

import java.net.URISyntaxException;
import java.util.Objects;

public class Juguete extends Item{
    private final Image im;

    //Constructor del Objeto Item Juguete
    public Juguete(String name, int id, String imageLocation) {
        super(name, id, -1);
        // La imagen se busca en el ClassPath, que es la carpeta ./target/classes
        im = new Image(Objects.requireNonNull(Main.class.getResourceAsStream(imageLocation)));
    }

    public void actionItem(Mascota mascota){
        int current_happiness = mascota.getHappiness().get();
        mascota.setHappiness(current_happiness+30);
    }

    public ImageView getImageView() {
        return new ImageView(im);
    }

}