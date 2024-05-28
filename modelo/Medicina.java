package juegomascotavirtual.modelo;

public class Medicina extends Item{

    //Constructor del Objeto Item Medicina
    public Medicina(String name, int id, int stock ){
        super(name, id, stock);
    }



    public void actionItem(Mascota mascota){
        int current_health = mascota.getHealth().get();
        mascota.setHealth(current_health+40);
        decreaseStock();
    }
}