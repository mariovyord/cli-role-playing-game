public class Monster extends Creature {
  public Monster(String name, int health, int damage) {
    super(name, health, damage, CombatantType.MONSTER);
  }
}
