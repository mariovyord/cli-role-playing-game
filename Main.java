import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    System.out.println("Booting game... Timestamp: " + formatter.format(now));
    System.out.println();

    Game game = new Game();
    game.start();
  }
}