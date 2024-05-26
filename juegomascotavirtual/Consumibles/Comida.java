package Consumibles;
import Permanentes.Mascota;

import java.util.concurrent.TimeUnit;

public class Comida extends Item{

    //Constructor del Objeto Item Comida
    public Comida (String name, int id, int stock ){
        super(name, id, stock);
    }


    //Print de la acción del Item aplicado
    public void printItemAplicado(){
        String text1 = "Dando de comer " + name;
        String text2 = " mmmmmm comiiiiida";
        printItemTemplate(text1, text2);
    }

    public void actionItem(Mascota mascota){
        int current_energy = mascota.getEnergy();
        mascota.setEnergy(current_energy+20);

        int current_health = mascota.getHealth();
        mascota.setHealth(current_health+20);

        decreaseStock();
    }
}
