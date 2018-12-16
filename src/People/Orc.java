package People;

public class Orc extends Monster{
    public Orc(int health, String name, int strength) {
        super(health, name, strength);
    }


    @Override
    public String getImage(){
        return "                        _,.---''```````'-.\n" +
                "                    ,-'`                  `-._\n" +
                "                 ,-`                   __,-``,\\\n" +
                "                /             _       /,'  ,|/ \\\n" +
                "              ,'         ,''-<_`'.    |  ,' |   \\\n" +
                "             /          / _    `  `.  | / \\ |\\  |\n" +
                "             |         (  |`'-,---, `'  \\_|/ |  |\n" +
                "             |         |`  \\  \\|  /  __,    _ \\ |\n" +
                "             |         |    `._\\,'  '    ,-`_\\ \\|\n" +
                "             |         |        ,----      /|   )\n" +
                "             \\         \\       / --.      {/   /|\n" +
                "              \\         | |       `.\\         / |\n" +
                "               \\        / `-.                 | /\n" +
                "                `.     |     `-        _,--V`)\\/        _,-\n" +
                "                  `,   |           /``V_,.--`  \\.  _,-'`\n" +
                "                   /`--'`._        `-'`         )`'\n" +
                "                  /        `-.            _,.-'`\n" +
                "                              `-.____,.-'`";
    }

}
