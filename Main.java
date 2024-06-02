import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import utils.Counter;

public class Main {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    System.out.println("Booting game... Timestamp: " + now.format(formatter));

    Counter counter = new Counter();
    Thread thread1 = new Thread(counter);
    thread1.start();

    try {
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println();

    Game game = new Game();
    game.start();
  }
}