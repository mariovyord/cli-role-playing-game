package creatures;

public interface Combatant {
    void attack(Combatant opponent);

    void takeDamage(int damage);

    void takeHealth(int health);

    boolean isAlive();

    String getName();

    int getHealth();

    int getMaxHealth();

    int getDamage();

    CombatantType getType();
}