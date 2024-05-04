package actions;

import java.util.ArrayList;
import java.util.Random;

import items.FireGranade;
import items.HealingPotion;
import items.Item;

public class ItemDroppper {
    ArrayList<Item> items = new ArrayList<>();

    public ItemDroppper() {
        items.add(new HealingPotion());
        items.add(new FireGranade());
    }

    public Item dropRandom() {
        return items.get(new Random().nextInt(items.size()));
    }
}
