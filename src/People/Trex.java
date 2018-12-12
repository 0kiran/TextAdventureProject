package People;

public class Trex extends Monster {
    public Trex(int health, String name, int strength) {
        super(health, name, strength);
    }

    @Override
    public void attack() {
    }

    public String getImage() {
        return "                                              ____\n" +
                "   ___                                      .-~. /_\"-._\n" +
                "  `-._~-.                                  / /_ \"~o\\  :Y\n" +
                "      \\  \\                                / : \\~x.  ` ')\n" +
                "       ]  Y                              /  |  Y< ~-.__j\n" +
                "      /   !                        _.--~T : l  l<  /.-~\n" +
                "     /   /                 ____.--~ .   ` l /~\\ \\<|Y\n" +
                "    /   /             .-~~\"        /| .    ',-~\\ \\L|\n" +
                "   /   /             /     .^   \\ Y~Y \\.^>/l_   \"--'\n" +
                "  /   Y           .-\"(  .  l__  j_j l_/ /~_.-~    .\n" +
                " Y    l          /    \\  )    ~~~.\" / `/\"~ / \\.__/l_\n" +
                " |     \\     _.-\"      ~-{__     l  :  l._Z~-.___.--~\n" +
                " |      ~---~           /   ~~\"---\\_  ' __[>\n" +
                " l  .                _.^   ___     _>-y~\n" +
                "  \\  \\     .      .-~   .-~   ~>--\"  /\n" +
                "   \\  ~---\"            /     ./  _.-'\n" +
                "    \"-.,_____.,_  _.--~\\     _.-~\n" +
                "                ~~     (   _}\n" +
                "                        `. ~(\n" +
                "                          )  \\\n" +
                "                         /,`--'~\\--'";
    }

    public String toString() {
        return getImage() + "\n NAME:" + getName()+ "\n HEALTH:" + getHealth() + "\nSTRENGTH:"+getStrength();
    }
}
