package quest;

public class Weapon extends Card {

    private int damage;

    public Weapon(String paramName, String paramImageFilename, int paramDamage){
        super(paramName, paramImageFilename);
        damage = paramDamage;
    }

    public int getDamage(){
        return damage;
    }

}