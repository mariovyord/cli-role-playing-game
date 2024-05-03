import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Monster> monsters;
    private ArrayList<String> locations;
    private Monster darkLord;
    private Random random;

    public Game() {
      locations = new ArrayList<>(Arrays.asList("the dark forest", "the haunted swamp", "the misty mountains", "the abandoned village"));
      monsters = MonstersFactory.createMonsters();
      darkLord = new Monster("Dark Lord", 100, 30);
      random = new Random();
    }

    public void start() {
        System.out.println("Welcome to The Ring of Power: Journey to the Dark Lord's Castle");
        System.out.println("Press 'enter' to continue...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 

        System.out.println("Choose a player name:");
        String name = scanner.nextLine();

        Player player = new Player(name, 100, 20);
        
        System.out.println("As " + player.getName() + ", a mighty warrior, you embark on a perilous journey into the heart of darkness.");
        
        int round = 0;
        while (player.isAlive() && round <= 10) {
          Monster enemy;

          if (round == 10) {
            enemy = darkLord; // The Dark Lord is the final boss
          } else {
            enemy = selectRandomMonster();
          }

          String location;
          if (round == 10) {
              location = "the castle"; // Final battle with the Dark Lord at the castle
          } else {
              location = selectRandomLocation();
          }

          Battle battle = new Battle(location);
          battle.start(player, enemy);

          Delay.run(500);
          round++;
        }

        if (player.isAlive()) {
          endGame();
        } else {
          System.out.println("\nYou have been defeated! Your journey ends here.");
        }

        scanner.close();
    }

    private Monster selectRandomMonster() {
      int index = random.nextInt(monsters.size());
      return monsters.get(index);
    }

    private String selectRandomLocation() {
      int index = random.nextInt(locations.size());
      return locations.get(index);
    }

    private void endGame() {
      System.out.println("\nCongratulations, brave warrior!");
      System.out.println("With unwavering courage, you have vanquished the Dark Lord.");
      System.out.println("The Ring of Power is now yours to wield, its fate intertwined with your own.");

    }
}
