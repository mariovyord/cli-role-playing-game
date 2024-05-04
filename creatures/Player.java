package creatures;

public class Player extends Creature {
  public Player(String name, int health, int damage) {
    super(name, health, damage, CombatantType.PLAYER);
  }

  public void printStats() {
    System.out.println("Player: " + getName() + "; Health: " + getHealth() + "; Damage: " + getDamage());
  }
}
