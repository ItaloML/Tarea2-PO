package componentesGraficos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EscenaMascota extends StackPane {
    private final Image fondo;
    // private final Image fondoNegro;
    // private final Image avatarMascota;

    public EscenaMascota() throws FileNotFoundException {
        fondo = new Image(new FileInputStream(System.getProperty("user.dir") + "/pou2.png"));
        ImageView imageview = new ImageView(fondo);
        imageview.setFitHeight(600);
        imageview.setFitWidth(600);
        getChildren().add(imageview);
    }

    // public void apagarLuz() {;}
    // public void encenderLuz() {;}
}
