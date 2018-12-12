package People;

public abstract class Monster {
    private int health;
    private String name;
    private int strength;

    public Monster(int health, String name, int strength){
        this.health = health;
        this.name = name.toUpperCase();
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public abstract void attack();

}
