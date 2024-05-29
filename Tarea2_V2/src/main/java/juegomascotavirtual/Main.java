package juegomascotavirtual;

import juegomascotavirtual.controlador.Controlador;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juegomascotavirtual.vista.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    private List<String> args;

    @Override
    public void init() {
        // Store the command-line arguments for later use
        args = getParameters().getRaw();
    }

    public void start(Stage primaryStage) throws FileNotFoundException {
        // Lectura de archivo config.csv y consecuente creación de la Mascota y el Inventario. Si no lo encuentra arroja excepción.
        Scanner in = new Scanner(new File(args.getFirst()));
        Controlador controlador = new Controlador(in);
        View view = controlador.getView();
        // Display
        primaryStage.setScene(new Scene(view, 1175,900));
        primaryStage.setTitle("Pou 2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
