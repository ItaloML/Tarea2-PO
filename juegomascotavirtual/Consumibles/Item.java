package Consumibles;

import Permanentes.Mascota;

import java.util.concurrent.TimeUnit;


public abstract class Item {
    //Atributos para todas las clases de Items
    final int id;
    final String name;
    int stock;

    // Constructor (general para todas las subclases también)
    public Item(String name, int id, int stock){
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    // Métodos concretos de la super clase:

    // Getters:
    public int getStock(){return stock;}
    public int getId() {return id;}
    public String getName() {return name;}

    public void decreaseStock() {
        stock = stock - 1;
    }

    public void printItemTemplate(String text1, String text2){
        System.out.print(text1);
        for (int i = 0; i<4; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.print(text2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    //Metodos abstractos a ser implementados en cada Item correspondiente:
    public abstract void printItemAplicado();
    public abstract void actionItem(Mascota mascota);
}
