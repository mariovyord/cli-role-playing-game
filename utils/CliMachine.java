package utils;

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

    public static int encounter(String question) {
        System.out.println(question);
        String answer = System.console().readLine().trim();

        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return encounter(question);
        }
    }

    public static String ask(String question) {
        System.out.println(question);
        return System.console().readLine().trim();
    }
}
