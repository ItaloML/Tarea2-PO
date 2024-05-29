package com.example.tarea2etapafinal.modelo;



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
    // Otros
    public void decreaseStock() {
        stock = stock - 1;
    }



    //Metodos abstractos a ser implementados en cada Item correspondiente:
    public abstract void actionItem(Mascota mascota);
}
