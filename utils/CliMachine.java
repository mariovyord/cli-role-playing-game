package utils;

import java.lang.reflect.Array;

/*
 * Class used to handle the CLI commands
 * * Print message
 * * Ask the player a question
 * * Get the player's answer
 */
public class CliMachine {
    private CliMachine() {
        // private constructor to hide the implicit public one
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String[] messages) {
        for (String msg : messages) {
            System.out.println(msg);
        }
    }

    public static void pause() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
