package utils;

public class Delay {

    private Delay() {
        // private constructor to hide the implicit public one
    }

    public static void run(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
            Thread.currentThread().interrupt();
        }
    }
}
