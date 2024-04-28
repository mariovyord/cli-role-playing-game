import java.util.Scanner;

public class Game {
    public void start() {
        System.out.println("Welcome to The Ring of Power: Journey to the Dark Lord's Castle");
        System.out.println("Press any key to continue...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for user input to continue

        System.out.println("Choose a player name:");
        String name = scanner.nextLine();

        Player player = new Player(name);

        Delay.run(500);
        // First encounter
        System.out.println("As " + player.getName() + ", a mighty warrior, you embark on a perilous journey into the heart of darkness.");
        System.out.println("Your path leads you through a dense, eerie forest shrouded in shadow.");

        Battle battle = new Battle("the dark forest");
        Monster monster = new Monster("a menacing gnome");
        battle.start(player, monster);

        scanner.close();
    }
}
