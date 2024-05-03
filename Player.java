public class Player {
  private int health;
  private int damage;
  private String name;

  public Player(String name, int health, int damage) {
    this.name = name;
    this.health = health;
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

  public boolean isAlive() {
    return health > 0;
  }

  public void attack(Monster monster) {
    System.out.println(this.name + " attacks " + monster.getName() + " for " + damage + " damage!");
    monster.takeDamage(damage);
  }
}
