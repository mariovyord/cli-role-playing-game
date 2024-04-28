public class Monster {
  private int health;
  private int damage;
  private String name;

  public Monster(String name) {
    this.name = name;
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

  public void attack(Player player) {
    System.out.println(this.name + " attacks " + player.getName() + " for " + damage + " damage!");
    player.takeDamage(damage);
  }
}
