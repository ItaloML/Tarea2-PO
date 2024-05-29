package com.example.tarea2etapafinal.modelo;

public class Medicina extends Item{

    //Constructor del Objeto Item Medicina
    public Medicina(String name, int id, int stock ){
        super(name, id, stock);
    }



    public static Medicina copyOf(Medicina other) {
        return new Medicina(other.name, other.id, other.stock);
    }

    @Override
    public void actionItem(Mascota mascota){
        int current_health = mascota.getHealth().get();
        mascota.setHealth(current_health+40);
        decreaseStock();
    }
}