package People;

public class Trex extends Monster {
    public Trex(int health, String name, String image, int strength) {
        super(health, name, image, strength);
    }

    @Override
    public int attack() {
        return getStrength()*2;
    }
}
