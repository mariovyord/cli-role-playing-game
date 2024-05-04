package items;

import creatures.Combatant;

public class HealingPotion implements Item {
    private String name = "Healing Potion";
    private int healAmount = 10;
    private String description = "A potion that heals the user for " + healAmount + " health";

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Combatant user, Combatant enemy) {
        user.takeHealth(healAmount);
        System.out.println(user.getName() + " drinks a healing potion and heals for " + healAmount + " health!");
    }

}
