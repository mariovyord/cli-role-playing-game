package items;

import creatures.Combatant;

public class FireGranade implements Item {
    private String name = "Fire Granade";
    private int damage = 10;
    private String description = "A granade that explodes in a burst of fire for" + damage + " damage";

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Combatant user, Combatant enemy) {
        enemy.takeDamage(damage);
        System.out.println(
                user.getName() + " throws a fire granade at " + enemy.getName() + " for " + damage + " damage!");
    }

}
