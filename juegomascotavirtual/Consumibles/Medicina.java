package Consumibles;
import Permanentes.Mascota;

public class Medicina extends Item{

    //Constructor del Objeto Item Medicina
    public Medicina(String name, int id, int stock ){
        super(name, id, stock);
    }


    //Print de la acción del Item aplicado
    public void printItemAplicado(){
        String text1 = "Aplicando medicamento " + name;
        String text2 = ", podría ser paracetamol";
        printItemTemplate(text1, text2);
    }


    public void actionItem(Mascota mascota){
        int current_health = mascota.getHealth();
        mascota.setHealth(current_health+40);
        decreaseStock();
    }
}