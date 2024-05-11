package creatures;

import utils.CliMachine;

public class Player extends Creature {
  public Player(String name, int health, int damage) {
    super(name, health, damage, CombatantType.PLAYER);
  }

  public void printStats() {
    CliMachine.print("Player: " + getName() + "; Health: " + getHealth() + "; Damage: " + getDamage());
  }
}
