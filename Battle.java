import java.util.Scanner;

public class Battle {
    private String location;

    public Battle(String location) {
        this.location = location;
    }

    public void start(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in " + location + " and you see " + monster.getName() + " blocking the path! What do you do?");

        while (player.isAlive() && monster.isAlive()) {
            System.out.println("1. Attack");
            System.out.println("2. Run");
            int choice =  scanner.nextInt();
            Delay.run(500);
            switch (choice) {
                case 1:
                    player.attack(monster);    
                    
                    if (!monster.isAlive()) {
                        System.out.println("You defeated " + monster.getName() + "!");
                        break;
                    }

                    if ((monster.getHealth() < monster.getMaxHealth() / 2) && monster.getType().equals(CombatantType.BOSS) && Math.random() < 0.5) {
                        // If monster is at less than half health there is chance to flee
                        System.out.println(monster.getName() + " flees from the battle!");
                        break;
                    }

                    monster.attack(player);

                    if (!player.isAlive()) {
                        System.out.println("You were defeated by " + monster.getName() + "!");
                        break;
                    }
                    break;
                case 2:
                    flee();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to attack or 2 to run.");
            }
        }
    }
  
    private void flee() {
        System.out.println("You try to flee from battle.");
    }
}
