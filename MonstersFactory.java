import java.util.ArrayList;
import java.util.List;

public class MonstersFactory {
    public static List<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        
        monsters.add(new Monster("Goblin"));
        monsters.add(new Monster("Orc"));
        monsters.add(new Monster("Troll"));
        monsters.add(new Monster("Minotaur"));
        monsters.add(new Monster("Wild Boar"));

        return monsters;
    }
}