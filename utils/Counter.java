package utils;

public class Counter implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
        System.out.println("Go!");
    }
}
