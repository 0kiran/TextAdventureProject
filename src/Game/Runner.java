package Game;

import People.Person;
import Rooms.MonsterRoom;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {


    public static boolean gameOn = true;
    public static int mrcount;
    public static void main(String[] args)
    {

            Room[][] map = new Room[5][5];
            Board board = new Board(map);
            //Setup player 1 and the input scanner
            Scanner in = new Scanner(System.in);
            System.out.println("Welcome to Dungeon Brawl! (The game looks best if you set your terminal as the full window) \nWhat is your name?");
            String name = in.nextLine();
            Person player1 = new Person(name, 0, 0,100,0,1);
            System.out.println("Hello, " + player1.getName()+".");
            System.out.println("How big is your dungeon? (min: 2x2)");
            System.out.println("HEIGHT:");
            String height = in.nextLine();
            System.out.println("WIDTH:");
            String width = in.nextLine();
            try{
                int heightint = Integer.parseInt(height);
                int widthint = Integer.parseInt(width);
                map = new Room[heightint][widthint];
                board = new Board(map);


                board.build();
            }catch (NumberFormatException ex) {
                System.out.println("Those don't seem to be numbers...");
                System.out.print("How about 5 by 5?");
                board.build();
            }
            System.out.println("In each of the rooms marked with an 'M' you will find a monster! \nSpit, punch, kick, and gnaw your way through each monster room and make it to the finish! \n(hint: they have very low self-esteem, do massive damage with the move insult!)\n");
            map[0][0].enterRoom(player1);

            mrcount = board.mrcount;

            while(gameOn)
            {
                board.print();
                System.out.println(player1);
                for (int i = 0; i < player1.getInventory().length; i++) {
                    if(player1.getInventory()[i] != null && player1.getInventory()[i].equals("Meat")){
                        System.out.println("Where would you like to move? (Choose N, S, E, W) or eat your meat with C");
                        break;
                    }
                    else if(i == player1.getInventory().length-1){
                        System.out.println("Where would you like to move? (Choose N, S, E, W)");
                    }
                }



                String move = in.nextLine();
                if(validMove(move, player1, map))
                {
                    System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

                }
                if(move.equals("C") || move.equals("c")){
                    for (int i = 0; i < player1.getInventory().length; i++) {
                        if(player1.getInventory()[i] != null && player1.getInventory()[i].equals("Meat")){
                            player1.health += 20;
                            player1.getInventory()[i] = null;
                            System.out.println("You ate your meat.");
                            break;
                        }
                        else if(i == player1.getInventory().length-1){
                            System.out.println("Please choose a valid move.");
                        }
                    }
                }
                else {
                    System.out.println("Please choose a valid move.");
                }


            }
            in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
