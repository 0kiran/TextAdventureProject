package Items;

import People.Person;

public class Key implements Item{
    @Override
    public void addtoInventory(Person person) {
        person.getInventory()[0] = "Key";
    }

    @Override
    public void use(Person person) {
        person.getInventory()[0] = null;
    }
}
