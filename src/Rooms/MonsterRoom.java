package Rooms;

import Game.Board;
import Game.Runner;
import Items.Axe;
import Items.Key;
import Items.Meat;
import People.*;

import java.util.Scanner;

import static Game.Runner.mrcount;

public class MonsterRoom extends Room{
    private boolean inside = false;
    private boolean dead = false;

    public MonsterRoom(int x, int y){
        super(x,y);
    }

    @Override
    public String toString() {
        if(inside){
            return "[X]";
        }
        else if(dead){
            return "[?]";
        }
        else {
            return "[M]";
        }
    }

    public void enterRoom(Person x) {

        occupant = x;
        inside = true;
        if(dead){
            System.out.println("You enter a plain old room");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            inside = true;
        }
        // ADD random monster generator
        int monstertype = (int)(Math.random()*10);

        String[] adjectives = {"Brave", "Smelly", "Depressed","Anxious","Stressed","Holy","Uptight","Quiet","Defenseless"};
        int adjint = (int)(Math.random()*adjectives.length);

        Monster monster = new Trex((int)(Math.random()*20)+25,  adjectives[adjint]+" T-rex", (int)(Math.random()*100)+75);
        if(monstertype > 6) {
            monster = new Orc((int)(Math.random()*20)+40,adjectives[adjint]+" Orc",(int)(Math.random()*300)+100);
        }
        if(x.getKillcounter()+1 == mrcount){
            monster = new Demon(100,adjectives[adjint]+" Demon (BOSS)",(int)(Math.random()*400)+200);
        }

        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the monster! Prepare to fight.");
        System.out.println(monster);

        String health = "\nHEALTH:   ";
        String healthbar = "";
        int healthbarlength = 0;
        for(int i = 0; i < monster.getHealth(); i++){
            healthbar += "=";
            healthbarlength++;
        }
        int damage;
        int dealt = 0;

        Runner.gameOff();
        Scanner in2 = new Scanner(System.in);
        System.out.println(health + healthbar);

        while(dealt < healthbarlength){

            System.out.println("Type your attack move");
            String input = in2.nextLine();

            if(input.equals("punch")){
                damage = 4 * x.getDmg();
            }
            else if(input.equals("spit")){
                damage = 1 * x.getDmg();
            }
            else if(input.equals("gnaw")){
                damage = 3 * x.getDmg();
            }
            else if(input.equals("kick")){
                damage = 6 * x.getDmg();

            }
            else if(input.equals("wink")){
                damage = 10 * x.getDmg();
            }
            else if(input.equals("smile")){
                damage = 8 * x.getDmg();
            }
            else if(input.equals("insult")){
                damage = 12 * x.getDmg();
            }
            else if(input.equals("default dance")){
                damage = 200 * x.getDmg();
                System.out.println("The cringe is too strong!");
            }
            else{
                damage = 0;
                System.out.println("That isn't a move...");
            }
            dealt += damage;
            if (healthbar.length() - damage > 0) {
                healthbar = healthbar.substring(0, healthbar.length() - damage);
                System.out.println(monster);
                System.out.println(health + healthbar);
                if (damage >= 10) {
                    System.out.println("Super effective!");
                }
                System.out.println("You did " + damage + " damage!");
                monster.attack(x);
                if(x.getHealth() < 0){
                    break;
                }

            }
        }
        if(x.getHealth() < 0){
            System.out.println("GAME OVER.");
            System.out.println("You killed "+x.killcounter+" monsters.");

        }
        else {
            System.out.println("========================");
            System.out.println("\nYOU BEAT THE MONSTER!\n");

            if(x.getKillcounter()+1 == mrcount){
                Key key = new Key();
                key.addtoInventory(x);
                System.out.println("you got a key!");

            }
            if(monstertype > 6){
                Axe axe = new Axe();
                axe.addtoInventory(x);
                System.out.println("you got an axe!\nATTACK UP!");
            }
            if(monstertype <= 6){
                Meat meat = new Meat();
                meat.addtoInventory(x);
                System.out.println("you got some meat!\n");
            }

            System.out.println("========================");
            dead = true;
            Runner.gameOn = true;
            x.killcounter++;
        }


    }

    @Override
    public void leaveRoom(Person x) {
        super.leaveRoom(x);
        occupant = null;
        inside = false;
    }
}

