package Rooms;

import Game.Runner;
import Items.Key;
import People.Person;

public class WinningRoom extends Room
{
    private boolean inside = false;
    public WinningRoom(int x, int y) {
        super(x, y);

    }

    @Override
    public String toString() {
        if (inside) {
            return "{X}";
        }
        return "{W}";
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        inside = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        for (int i = 0; i < x.getInventory().length; i++) {
            if(x.getInventory()[i] != null && x.getInventory()[i].equals("Key")) {
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
                System.out.println("CONGRATULATIONS! YOU ESCAPED!");
                System.out.println("\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                Runner.gameOff();
                break;
            }
            else if(i == x.getInventory().length-1){
                System.out.println("It's locked. Crap.");
            }
        }


    }

    @Override
    public void leaveRoom(Person x) {
        super.leaveRoom(x);
        occupant = null;
        inside = false;
    }
}
