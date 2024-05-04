package items;

import creatures.Combatant;

public class HealingPotion implements Item {
    private String name;
    private String description;
    private int healAmount;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void use(Combatant target) {
        target.takeHealth(healAmount);
    }

}
