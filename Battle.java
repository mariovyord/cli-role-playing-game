import java.util.Scanner;

public class Battle {
    private String location;

    public Battle(String location) {
        this.location = location;
    }

    public void start(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in " + location + " and you see " + monster.getName() + " blocking the path! What do you do?");
        System.out.println("1. Attack");
        System.out.println("2. Run");

        boolean inBattle = true;

        while (inBattle) {
            int choice =  scanner.nextInt();
            Delay.run(500);
            switch (choice) {
                case 1:
                    fightRound(player, monster);
                    break;
                case 2:
                    flee();
                    inBattle = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to attack or 2 to run.");
            }
        }
        scanner.close();
    }
  

    private void fightRound(Player player, Monster monster) {
        System.out.println("You attack " + monster.getName() + "!");
        System.out.println("The battle continues...");
    }

    private void flee() {
        System.out.println("You try to flee from battle.");
    }
}
