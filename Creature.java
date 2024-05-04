public abstract class Creature implements Combatant {
  private int health;
  private int maxHealth;
  private int damage;
  private CombatantType type;
  private String name;

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
}
