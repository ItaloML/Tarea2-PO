package juegomascotavirtual.modelo;


public class Comida extends Item{

    //Constructor del Objeto Item Comida
    public Comida (String name, int id, int stock ){
        super(name, id, stock);
    }


    public static Comida copyOf(Comida other) {
        return new Comida(other.name, other.id, other.stock);
    }

    public void actionItem(Mascota mascota){
        int current_energy = mascota.getEnergy().get();
        mascota.setEnergy(current_energy+20);

        int current_health = mascota.getHealth().get();
        mascota.setHealth(current_health+20);
        decreaseStock();
    }


}
