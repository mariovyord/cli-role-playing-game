package items;

import creatures.Combatant;

public class FireGranade implements Item {
    private String name;
    private String description;
    private int damage;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Combatant target) {
        target.takeDamage(damage);
    }

}
