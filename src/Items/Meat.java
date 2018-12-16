package Items;

import People.Person;

public class Meat implements Item {

    public void addtoInventory(Person person) {
        for(int i = 0; i < person.getInventory().length; i++){
            if(person.getInventory()[i] == null){
                person.getInventory()[i] = "Meat";
                break;
            }
        }
    }

}
