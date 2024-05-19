package items;

import creatures.Combatant;
import utils.CliMachine;

public class Grenade implements Item {
    private String name;
    private int damage;
    private String description = "A grenade that explodes for" + damage + " damage";

    public Grenade(String name, int damage) {
        this.damage = damage;
        this.name = name + " Grenade";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Combatant user, Combatant enemy) {
        enemy.takeDamage(damage);
        CliMachine.print(
                user.getName() + " throws a fire grenade at " + enemy.getName() + " for " + damage + " damage!");
    }

}
