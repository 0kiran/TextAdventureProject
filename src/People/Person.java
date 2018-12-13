package People;

import Items.Item;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String Name;
    int health;
    int xLoc, yLoc;
    String[] inventory = new String[4];


    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return Name;
    }

    public String[] getInventory(){
        return inventory;
    }
    public Person (String Name, int xLoc, int yLoc, int health)
    {
        this.Name = Name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.health = health;
    }

    @Override
    public String toString() {
        return Name + ':' +" health = " + health;
    }


}
