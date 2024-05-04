package actions;

import java.util.Scanner;

import creatures.CombatantType;
import creatures.Monster;
import creatures.Player;
import items.Item;
import utils.Delay;

public class Battle {
    private String location;
    final float DROP_ITEM_CHANCE = 0.3f;

    public Battle(String location) {
        this.location = location;
    }

    public void start(Player player, Monster monster) {
        ItemDroppper itemDroppper = new ItemDroppper();
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "You are in " + location + " and you see " + monster.getName() + " blocking the path! What do you do?");

        boolean isBattleOver = false;
        while (player.isAlive() && monster.isAlive() && !isBattleOver) {
            System.out.println("1. Attack");
            System.out.println("2. Run");
            int choice = scanner.nextInt();
            scanner.nextLine();
            Delay.run(500);
            switch (choice) {
                case 1:
                    player.attack(monster);

                    if (!monster.isAlive()) {
                        System.out.println("You defeated " + monster.getName() + "!");

                        // Change for player to get item
                        if (Math.random() < DROP_ITEM_CHANCE) {
                            Item item = itemDroppper.dropRandom();
                            player.addItem(item);
                            System.out.println("You found an item: " + item.getName());
                        }

                        break;
                    }

                    if ((monster.getHealth() < monster.getMaxHealth() / 2)
                            && monster.getType().equals(CombatantType.BOSS) && Math.random() < 0.5) {
                        // If monster is at less than half health there is chance to flee
                        System.out.println(monster.getName() + " flees from the battle!");
                        break;
                    }

                    monster.attack(player);

                    if (!player.isAlive()) {
                        System.out.println("You were defeated by " + monster.getName() + "!");
                        break;
                    }

                    // Give player a choice to use item
                    if (!player.getItems().isEmpty()) {
                        System.out.println("Do you want to use an item? (yes/no)");
                        String useItem = scanner.nextLine();
                        if (useItem.equalsIgnoreCase("yes")) {
                            player.printItems();
                            System.out.println("Enter the item number to use:");
                            int itemNumber = scanner.nextInt();
                            scanner.nextLine();
                            player.useItem(itemNumber, player, monster);
                            Delay.run(500);
                        }

                        if (!monster.isAlive()) {
                            System.out.println("You defeated " + monster.getName() + "!");
                            break;
                        }
                    }

                    break;
                case 2:
                    // While trying to flee there is a chance to take damage
                    if (Math.random() < 0.5) {
                        System.out.println("You get hurt while trying to flee for " + monster.getDamage() + " damage!");
                        player.takeDamage(monster.getDamage());
                    } else {
                        System.out.println("You successfully fled from " + monster.getName() + "!");
                    }

                    isBattleOver = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to attack or 2 to run.");
            }
        }
    }
}
