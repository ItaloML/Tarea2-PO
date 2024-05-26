package Consumibles;
import Permanentes.Mascota;

public class Juguete extends Item{

    //Constructor del Objeto Item Juguete
    public Juguete(String name, int id, int stock ){
        super(name, id, stock);
    }

    //Print de la acción del Item aplicado
    public void printItemAplicado(){
        String text1 = "Jugando con " + name+ " hasta que se rompa";
        String text2 = " wheeeeeeee!";
        printItemTemplate(text1, text2);
    }


    public void actionItem(Mascota mascota){
        int current_happiness = mascota.getHappiness();
        mascota.setHappiness(current_happiness+30);
    }
}