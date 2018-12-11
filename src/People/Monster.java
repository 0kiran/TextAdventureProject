package People;

public abstract class Monster {
    private int health;
    private String name;
    private String image;
    private int strength;

    public Monster(int health, String name, String image, int strength){
        this.health = health;
        this.name = name;
        this.image = image;
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return getImage() + "\n NAME:" + getName()+ "\n HEALTH:" + getHealth() + "\nSTRENGTH:"+getStrength();
    }

    public abstract void attack();

}
