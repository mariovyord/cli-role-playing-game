package creatures;

import java.util.ArrayList;

import items.Item;

public abstract class Creature implements Combatant {
  private int health;
  private int maxHealth;
  private int damage;
  private CombatantType type;
  private String name;
  private ArrayList<Item> items = new ArrayList<>();

  public Creature(String name, int health, int damage, CombatantType type) {
    this.name = name;
    this.health = health;
    this.maxHealth = health;
    this.damage = damage;
    this.type = type;
  }

  @Override()
  public String toString() {
    return name + "; Health: " + health + "; Damage: " + damage;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

  public void takeHealth(int health) {
    this.health += health;
    if (this.health > maxHealth) {
      this.health = maxHealth;
    }
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public boolean isAlive() {
    return health > 0;
  }

  public int getDamage() {
    return damage;
  }

  public void attack(Combatant enemy) {
    System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage!");
    enemy.takeDamage(damage);
  }

  public CombatantType getType() {
    return type;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void printItems() {
    for (int i = 0; i < items.size(); i++) {
      System.out.println(i + ": " + items.get(i).getName());
    }
  }

  private static final String INVALID_ITEM_INDEX_MESSAGE = "Invalid item index";

  public void printItem(int index) {
    if (index < 0 || index >= items.size()) {
      System.out.println(INVALID_ITEM_INDEX_MESSAGE);
      return;
    }
    System.out.println(items.get(index).getName());
  }

  public void useItem(int index, Combatant user, Combatant enemy) {
    if (index < 0 || index >= items.size()) {
      System.out.println(INVALID_ITEM_INDEX_MESSAGE);
      return;
    }
    Item item = items.get(index);
    item.use(user, enemy);
    items.remove(index);
  }

  public Item dropItem(int index) {
    if (index < 0 || index >= items.size()) {
      System.out.println(INVALID_ITEM_INDEX_MESSAGE);
      return null;
    }
    return items.remove(index);
  }
}
