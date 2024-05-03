public class Monster {
  private int health;
  private int maxHealth;
  private int damage;
  private String name;

  public Monster(String name, int health, int damage) {
    this.name = name;
    this.health = health;
    this.maxHealth = health;
    this.damage = damage;
  }

  @Override()
  public String toString() {
    return "Monster: " + name + "; Health: " + health + "; Damage: " + damage;
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

  public void attack(Player player) {
    System.out.println(this.name + " attacks " + player.getName() + " for " + damage + " damage!");
    player.takeDamage(damage);
  }
}
