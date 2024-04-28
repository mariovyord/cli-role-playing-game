public class Player {
  private int health;
  private int damage;
  private String name;

  public Player(String name) {
    this.name = name;
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

  public void attack(Monster monster) {
    System.out.println(this.name + " attacks " + monster.getName() + " for " + damage + " damage!");
    monster.takeDamage(damage);
  }
}
