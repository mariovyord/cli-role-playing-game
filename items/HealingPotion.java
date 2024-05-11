package items;

import creatures.Combatant;
import utils.CliMachine;

public class HealingPotion implements Item {
    private String name;
    private int healAmount;
    private String description = "A potion that heals the user for " + healAmount + " health";

    public HealingPotion(String name, int healAmount) {
        this.healAmount = healAmount;
        this.name = name + " Healing Potion";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Combatant user, Combatant enemy) {
        user.takeHealth(healAmount);
        CliMachine.print(user.getName() + " drinks a healing potion and heals for " + healAmount + " health!");
    }
}
