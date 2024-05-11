package actions;

import creatures.CombatantType;
import creatures.Monster;
import creatures.Player;
import items.Item;
import utils.CliMachine;
import utils.Delay;

public class Battle {
    private String location;
    static final float DROP_ITEM_CHANCE = 0.3f;

    public Battle(String location) {
        this.location = location;
    }

    public void start(Player player, Monster monster) {
        ItemDropper itemDropper = new ItemDropper();

        CliMachine.print(
                "You are in " + location + " and you see " + monster.getName() + " blocking the path! What do you do?");

        boolean isBattleOver = false;
        while (player.isAlive() && monster.isAlive() && !isBattleOver) {
            String[] options = { "1. Attack", "2. Use Item", "3. Run" };
            int choice = CliMachine.encounter(String.join("\n", options));

            Delay.run(500);
            switch (choice) {
                case 1:
                    player.attack(monster);

                    if (!monster.isAlive()) {
                        CliMachine.print("You defeated " + monster.getName() + "!");

                        // Change for player to get item
                        if (Math.random() < DROP_ITEM_CHANCE) {
                            Item item = itemDropper.dropRandom();
                            player.addItem(item);
                            CliMachine.print("You found an item: " + item.getName());
                        }

                        break;
                    }

                    if ((monster.getHealth() < monster.getMaxHealth() / 2)
                            && monster.getType().equals(CombatantType.BOSS) && Math.random() < 0.5) {
                        // If monster is at less than half health there is chance to flee
                        CliMachine.print(monster.getName() + " flees from the battle!");
                        break;
                    }

                    monster.attack(player);

                    if (!player.isAlive()) {
                        CliMachine.print("You have been defeated by " + monster.getName() + "!");
                        break;
                    }

                    break;
                case 2:
                    if (!player.getItems().isEmpty()) {
                        player.printItems();
                        int itemNumber = CliMachine.encounter("Enter the item number to use:");

                        if (itemNumber < 0 || itemNumber >= player.getItems().size()) {
                            CliMachine.print("Invalid item number.");
                            break;
                        }

                        player.useItem(itemNumber, player, monster);
                        Delay.run(500);

                        if (!monster.isAlive()) {
                            CliMachine.print("You defeated " + monster.getName() + "!");
                            break;
                        }
                    } else {
                        CliMachine.print("You don't have any items to use.");
                    }
                    break;
                case 3:
                    // While trying to flee there is a chance to take damage
                    if (Math.random() < 0.5) {
                        CliMachine.print("You get hurt while trying to flee for " + monster.getDamage() + " damage!");
                        player.takeDamage(monster.getDamage());
                    } else {
                        CliMachine.print("You successfully fled from " + monster.getName() + "!");
                    }

                    isBattleOver = true;
                    break;
                default:
                    CliMachine.print("Invalid choice. Please enter '1' to attack or '2' to run.");
            }
        }
    }
}
