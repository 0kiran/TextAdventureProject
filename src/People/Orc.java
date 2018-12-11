package People;

public class Orc extends Monster{
    public Orc(int health, String name, String image, int strength) {
        super(health, name, image, strength);
    }

    @Override
    public void attack() {
        return getStrength()*10;
    }
}
