public class Player implements Combatant {
  private int health;
  private int maxHealth;
  private CombatantType type = CombatantType.PLAYER;
  private int damage;
  private String name;

  public Player(String name, int health, int damage) {
    this.name = name;
    this.health = health;
    this.maxHealth = health;
    this.damage = damage;
  }

  @Override()
  public String toString() {
    return "Player: " + name + "; Health: " + health + "; Damage: " + damage;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return health;
  }

  public CombatantType getType() {
    return type;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public boolean isAlive() {
    return health > 0;
  }

  public void attack(Combatant monster) {
    System.out.println(this.name + " attacks " + monster.getName() + " for " + damage + " damage!");
    monster.takeDamage(damage);
  }
}
