package creatures;

import java.util.ArrayList;
import java.util.List;

public class MonstersFactory {
    private MonstersFactory() {
        // private constructor to hide the implicit public one
    }

    public static List<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Goblin", 30, 5));
        monsters.add(new Monster("Orc", 50, 10));
        monsters.add(new Monster("Troll", 80, 15));
        monsters.add(new Monster("Minotaur", 100, 20));
        monsters.add(new Monster("Wild Boar", 20, 5));

        return monsters;
    }
}