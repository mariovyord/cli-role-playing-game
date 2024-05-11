import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import actions.Battle;
import creatures.Monster;
import creatures.MonstersFactory;
import creatures.Player;
import items.NormalHealingPotion;
import utils.CliMachine;
import utils.Delay;

/**
 * The Game class represents a game session.
 * <p>
 * This class handles the game loop, player actions, and game state.
 * It is responsible for starting and ending the game, and for processing player
 * actions during the game.
 */
public class Game {
  private List<Monster> monsters;
  private ArrayList<String> locations;
  private Monster darkLord;
  private Random random;

  public Game() {
    locations = new ArrayList<>(
        Arrays.asList("the dark forest", "the haunted swamp", "the misty mountains", "the abandoned village"));
    monsters = MonstersFactory.createMonsters();
    darkLord = new Monster("Dark Lord", 100, 30);
    random = new Random();
  }

  public void start() {
    CliMachine.print("Welcome to The Ring of Power: Journey to the Dark Lord's Castle");
    CliMachine.pause();

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    System.out.println("Choose a player name:");
    String name = scanner.nextLine();

    Player player = new Player(name, 100, 20);
    player.addItem(new NormalHealingPotion());

    CliMachine.print(
        "As " + player.getName() + ", a mighty warrior, you embark on a perilous journey into the heart of darkness.");

    int round = 0;
    while (player.isAlive() && round <= 10) {
      System.out.println("Press '1' to see player stats and '2' to continue your adventure.");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          player.printStats();
          break;
        case 2:
          break;
        default:
          break;
      }

      CliMachine.pause();

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

      if (!player.isAlive()) {
        break;
      }

      Delay.run(500);
      round++;
    }

    if (player.isAlive()) {
      endGame();
    } else {
      CliMachine.print("You have been defeated! Your journey ends here.");
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
    String[] msgs = {
        "You have reached the Dark Lord's castle, the final stage of your journey.",
        "The fate of Middle Earth rests on your shoulders.",
        "Prepare yourself for the ultimate battle!"
    };

    CliMachine.print(msgs);
  }
}
