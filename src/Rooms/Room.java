package Rooms;

import People.Person;

public class Room {
    Person occupant;
    int xLoc, yLoc;
    boolean inside = false;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    public String toString() {
        if(inside){
            return "[X]";
        }
        else {
            return "[?]";
        }
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You enter a plain old room");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        inside = true;
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
        inside = false;
    }
    

}

