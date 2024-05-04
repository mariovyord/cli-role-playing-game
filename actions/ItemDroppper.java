package actions;

import java.util.ArrayList;
import java.util.Random;

import items.FireGranade;
import items.Item;
import items.MagicGranade;
import items.NormalHealingPotion;
import items.MinorHealingPotion;

public class ItemDroppper {
    ArrayList<Item> items = new ArrayList<>();

    public ItemDroppper() {
        items.add(new NormalHealingPotion());
        items.add(new MinorHealingPotion());
        items.add(new FireGranade());
        items.add(new MagicGranade());
    }

    public Item dropRandom() {
        return items.get(new Random().nextInt(items.size()));
    }
}
