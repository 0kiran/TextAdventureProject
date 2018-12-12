package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class MonsterRoom extends Room{

    public MonsterRoom(int x, int y){
        super(x,y);
    }

    @Override
    public String toString() {
        if(inside){
            return "[X]";
        }
        return "[M]";
    }

    public void enterRoom(Person x) {

        occupant = x;
        // ADD random monster generator
        String monster = "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the monster! Prepare to fight.");
        System.out.println(monster);

        String health = "\nHEALTH: ";
        String healthbar = "  =============================================";
        int damage = 4;
        int dealt = 0;

        Runner.gameOff();
        Scanner in2 = new Scanner(System.in);
        System.out.println(health + healthbar);

        while(dealt < 45){

            System.out.println("Type your attack move");
            String input = in2.nextLine();

            if(input.equals("punch")){
                damage = 4;
                dealt += damage;
            }
            else if(input.equals("kick")){
                damage = 6;
                dealt += damage;
            }
            else if(input.equals("insult")){
                damage = 12;
                dealt += damage;
            }
            else{
                damage = 0;
                System.out.println("That isn't a move...");
            }
            if(healthbar.length()-damage > 0) {
                healthbar = healthbar.substring(0, healthbar.length() - damage);
                System.out.println(monster);
                System.out.println(health + healthbar);
                if (damage > 10) {
                    System.out.println("Super effective!");
                }
                System.out.println("You did " + damage + " damage!");
            }

        }

        System.out.println("========================");
        System.out.println("\nYOU BEAT THE MONSTER!\n");
        System.out.println("========================");
        Runner.gameOn = true;


    }
}

