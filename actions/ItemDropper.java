package actions;

import java.util.ArrayList;
import java.util.Random;

import items.FireGrenade;
import items.Item;
import items.MagicGrenade;
import items.NormalHealingPotion;
import items.MinorHealingPotion;

public class ItemDropper {
    ArrayList<Item> items = new ArrayList<>();

    public ItemDropper() {
        items.add(new NormalHealingPotion());
        items.add(new MinorHealingPotion());
        items.add(new FireGrenade());
        items.add(new MagicGrenade());
    }

    public Item dropRandom() {
        return items.get(new Random().nextInt(items.size()));
    }

}
