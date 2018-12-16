package Game;

import Rooms.MonsterRoom;
import Rooms.Room;
import Rooms.WinningRoom;

public class Board {
    private Room[][] map;
    private int area;
    public int mrcount = 0;

    public Board(Room[][] map) {
        this.map = map;
    }


    public void build(){

        for (int x = 0; x < map.length; x++)
        {
            for (int y = 0; y < map[x].length; y++)
            {
                map[x][y] = new Room(x,y);
                area++;
            }
        }

            //Create a random Winning room + makes sure it is not the spawn location
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map.length);
            while (x == 0 && y == 0) {
                x = (int) (Math.random() * map.length);
                y = (int) (Math.random() * map.length);
            }
            map[x][y] = new WinningRoom(x, y);
        for(int i = 0; i < area; i+=10) {
            //Create a random Monster room.

            int x2 = (int) (Math.random() * map.length);
            int y2 = (int) (Math.random() * map.length);
            while ((x2 == 0 && y2 == 0) || (x2 == x && y2 == y)) {
                x2 = (int) (Math.random() * map.length);
                y2 = (int) (Math.random() * map.length);
            }
            map[x2][y2] = new MonsterRoom(x2, y2);
            mrcount++;
        }
    }
    public void print() {
        String printstr = "";
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                printstr += map[x][y];
            }
            printstr += "\n";
        }
        System.out.println(printstr);
    }

    public int getMrcount(){
        return mrcount;
    }

}
