package juegomascotavirtual.modelo;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.concurrent.TimeUnit;

public class Mascota {

    private final Inventario inventarioMascota = new Inventario();
    private final String name;
    private final FloatProperty age = new SimpleFloatProperty();
    private final IntegerProperty health = new SimpleIntegerProperty();
    private final IntegerProperty energy = new SimpleIntegerProperty();
    private final IntegerProperty happiness = new SimpleIntegerProperty();
    private Estado state;

    //private final StringProperty name = new SimpleStringProperty();

    //Método para instansación del Objeto Permanentes.Mascota
    public Mascota(String name) {
        this.name = name;
        age.set(0);
        health.set(50);
        energy.set(50);
        happiness.set(50);
        state = Estado.Neutro;
    }


    // Métodos de Mascota:

    // Getters:

    public Inventario getInventarioMascota() {return inventarioMascota;}
    public FloatProperty getAge(){return age;}
    public IntegerProperty getHealth() {return health;}
    public IntegerProperty getEnergy() {return energy;}
    public IntegerProperty getHappiness() {return happiness;}
    public Estado getState() {return state;}
    public String getName() {return name;}

    // Setters: (añadimos la funcionalidad de mantener los atributos health, energy y happiness entre 0 y 100)
    public void setAge(float age) {this.age.set(age);}
    public void setState(){
        state = determineState();
    }
    public void setHealth(int x) {
        x = Math.max(0,Math.min(100,x));
        health.set(x);
    }
    public void setEnergy(int x) {
        x = Math.max(0,Math.min(100,x));
        energy.set(x);
    }
    public void setHappiness(int x) {
        x = Math.max(0,Math.min(100,x));
        happiness.set(x);
    }


    // Otros métodos:

    public Estado determineState(){
        if (age.get() > 15 || health.get() == 0 || energy.get() == 0) return Estado.Muerto;
        if (energy.get()<=15) return Estado.Cansado;
        if (age.get() > 5 && health.get() <= 30 && energy.get() <= 30) return Estado.Enojado;
        if ((age.get()<5 && health.get()<=20)||(age.get()>=5 && age.get()<=10 && health.get()<=50)) return Estado.Hambriento;
        if (happiness.get()<=20) return Estado.Triste;
        if (happiness.get()>=60) return Estado.Feliz;
        return Estado.Neutro;
    }


    //Hacer dormir a la Mascota
    public void sleep(){
        energy.set(100);
        setHappiness(happiness.get() + 15);
        setHealth(health.get() + 15);

        System.out.print("Durmiendo...");
        for (int i = 0; i<4; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.print("z");
        }
        System.out.print("... " + name + " ha dormido como tronco chaval a todo gas!!!");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void GetOld(){
        setAge(age.get() + (float) 0.5);
        setHealth(health.get()-5);
        setEnergy(energy.get()-5);
        setHappiness(happiness.get()-5);
        setState();
    }

    public void morir(){
        System.out.println("Siempre te recordaremos... R.I.P.");
    }

    public void reset() {
        age.set(0);
        health.set(50);
        energy.set(50);
        happiness.set(50);
        state = Estado.Neutro;
    }
}



