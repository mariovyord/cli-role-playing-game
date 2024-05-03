

public interface Combatant {
    void attack(Combatant opponent);
    void takeDamage(int damage);
    boolean isAlive();
    String getName();
    int getHealth();
    int getMaxHealth();
    CombatantType getType();
}