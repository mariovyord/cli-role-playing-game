package utils;

public class Delay {

    public static void run(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
            Thread.currentThread().interrupt();
        }
    }
}
