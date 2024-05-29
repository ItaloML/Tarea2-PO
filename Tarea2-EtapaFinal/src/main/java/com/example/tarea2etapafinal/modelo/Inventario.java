package com.example.tarea2etapafinal.modelo;

import java.util.ArrayList;




public class Inventario {
    private final ArrayList<Item> inventario = new ArrayList<Item>();

    public Inventario() {}


    public void addItem(String Type, String nombreItem, int id, int cantidad, String im) {
        Item aux = switch (Type) {
            case "Alimento" -> new Comida(nombreItem, id, cantidad);
            case "Medicina" -> new Medicina(nombreItem, id, cantidad);
            case "Juguete" -> new Juguete(nombreItem, id, im);
            default -> throw new IllegalStateException("Unexpected value: " + Type);
        };
        inventario.add(aux);
    }

    public ArrayList<Item> getInventario() {return inventario;}

    public void printInventario() {
        System.out.println("----Inventario----");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i).getId() + ", "
                    + inventario.get(i).getName() + ", "
                    + "Cantidad: " + inventario.get(i).getStock());
        }
    }
}
