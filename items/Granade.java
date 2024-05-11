package items;

import creatures.Combatant;
import utils.CliMachine;

public class Granade implements Item {
    private String name;
    private int damage;
    private String description = "A granade that explodes for" + damage + " damage";

    public Granade(String name, int damage) {
        this.damage = damage;
        this.name = name + " Granade";
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
                user.getName() + " throws a fire granade at " + enemy.getName() + " for " + damage + " damage!");
    }

}
