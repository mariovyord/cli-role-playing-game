package items;

import creatures.Combatant;

public interface Item {
    public String getName();

    public String getDescription();

    public void use(Combatant target);
}