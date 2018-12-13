package Items;

import People.Person;

public interface Item {

    void addtoInventory(Person person);

    void use(Person person);
}
