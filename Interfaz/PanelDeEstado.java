package Interfaz;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PanelDeEstado extends VBox {

    private final AnchorPane datosMascota = new AnchorPane();//Info de la mascota
    private final ProgressBar healthBar = createProgressBar(); //Barras de progreso
    private final ProgressBar energyBar = createProgressBar();
    private final ProgressBar happinessBar = createProgressBar();
    private final Text estado = new Text(); //Para mostrar un estado de ejemplo
    private final Text nameText = new Text(); //Pra mostrar un nombre de ejemplo

    //Crear la Barra de progreso
    private ProgressBar createProgressBar() {
        ProgressBar pb = new ProgressBar();
        pb.setPrefSize(450, 45);
        return pb;
    }

    //Constructor para inicializar TODO el panel de estado
    public PanelDeEstado(String name) {
        //El nombre y edad de la mascota
        nameText.setText("Nombre:\t\t" + name + "\n\nEdad:\t\t" + "20");
        nameText.setFont(Font.font("Arial", 20));
        datosMascota.getChildren().add(nameText);
        AnchorPane.setTopAnchor(nameText, 10.0);
        AnchorPane.setBottomAnchor(nameText, 10.0);
        AnchorPane.setLeftAnchor(nameText, 45.0);

        //Barras de progreso con los titulos correspondientes
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

        healthBar.setProgress(0.75); // Valor predeterminado
        energyBar.setProgress(0.50); // Valor predeterminado
        happinessBar.setProgress(0.90); // Valor predeterminado

        //Agregar los titulos y las barras al panel de atributos
        panelAtributos.getChildren().addAll(healthTitle, healthBar, energyTitle, energyBar, happinessTitle, happinessBar);

        //Mostrar estado de la mascota
        VBox estadoMascota = new VBox();
        estadoMascota.setAlignment(Pos.CENTER);
        Text estadoTitulo = new Text("Estado\n\n\n");
        estadoTitulo.setFont(Font.font("Arial", 24));
        estado.setText("Feliz");
        estado.setFont(Font.font("Arial", 48));
        estadoMascota.getChildren().addAll(estadoTitulo, estado);

        //Agregar los componentes al panel principal
        getChildren().addAll(datosMascota, panelAtributos, estadoMascota);
        setPrefWidth(400);
        setSpacing(25);
    }
}
