package Permanentes;

import java.util.concurrent.TimeUnit;

public class Mascota {

    // Atributos de la clase Permanentes.Mascota
    private static Mascota instance;
    private static String name;
    private static float age;
    private static int health;
    private static int energy;
    private static int happiness;
    private static Estado state;


    //Método para instansación del Objeto Permanentes.Mascota
    private Mascota(String name) {
        Mascota.name = name;
        age = 0;
        health = 50;
        energy = 50;
        happiness = 50;
        state = Estado.Neutro;
    }

    public static void Initialize(String name) {
        if (instance == null) {
            instance = new Mascota(name);
        } else {
            throw new IllegalStateException("La mascota ya ha sido inicializada");
        }
    }

    public static Mascota getInstance() {
        if (instance == null) {
            throw new IllegalStateException("La mascota aún no ha sido inicializada. LLame al método initialize() primero");
        }
        return instance;
    }

    // Métodos de Mascota:

    // Getters:
    public float getAge(){return age;}
    public int getHealth() {return health;}
    public int getEnergy() {return energy;}
    public int getHappiness() {return happiness;}
    public Estado getState() {return state;}
    public String getName() {return name;}

    // Setters: (añadimos la funcionalidad de mantener los atributos health, energy y happiness entre 0 y 100)
    public void setAge(float age) {this.age = age;}
    public void setState(){
        state = determineState();
    }
    public void setHealth(int x) {
        x = Math.max(0,Math.min(100,x));
        health = x;
    }
    public void setEnergy(int x) {
        x = Math.max(0,Math.min(100,x));
        energy = x;
    }
    public void setHappiness(int x) {
        x = Math.max(0,Math.min(100,x));
        happiness = x;
    }


    // Otros métodos:

    public Estado determineState(){
        if (age > 15 || health == 0 || energy == 0) return Estado.Muerto;
        if (energy<=15) return Estado.Cansado;
        if (age > 5 && health <= 30 && energy <= 30) return Estado.Enojado;
        if ((age<5 && health<=20)||(age>=5 && age<=10 && health<=50)) return Estado.Hambriento;
        if (happiness<=20) return Estado.Triste;
        if (happiness>=60) return Estado.Feliz;
        return Estado.Neutro;
    }

    public static String getStateIcon(Estado estado){
        return switch (estado) {
            case Muerto -> "(x_x) Fin del juego";
            case Feliz -> "\\(^o^)/ Weeeeeeeh!";
            case Triste -> "(._.) snif....";
            case Hambriento -> "(0o0) hambre hambre!";
            case Enojado -> "(ôwô) grrrr....";
            case Cansado -> "(=_=) zzzz....";
            default -> "(-_-) meh....";
        };
    }

    // Devolvemos un string que describe la situación actual de la Mascota
    public static void printIndicators() {
        String indicators = "";
        indicators += "\n-----------------";
        indicators += "\n    Atributos";
        indicators += "\n-----------------";
        indicators += "\nNombre: " + name;
        indicators += "\nEdad: " + age;
        indicators += "\nSalud: " + health;
        indicators += "\nEnergia: " + energy;
        indicators += "\nFelicidad: " + happiness;
        indicators += "\nEstado:" + getStateIcon(state);
        System.out.println(indicators);
    }


    //Hacer dormir a la Mascota
    public void sleep(){
        energy = 100;
        setHappiness(happiness + 15);
        setHealth(health + 15);

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
        setAge(age + (float) 0.5);
        setHealth(health-5);
        setEnergy(energy-5);
        setHappiness(happiness-5);
        setState();
    }

    public void morir(){
        System.out.println("\n"+getStateIcon(Estado.Muerto));
        System.out.println(name + " ha vivido hasta la noble edad de "+ age + " tiempos de simulación.");
        System.out.println("Siempre te recordaremos... R.I.P.");
    }
}



