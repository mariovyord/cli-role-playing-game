package utils;

import java.util.List;

import creatures.Player;

public class HealAll {

    private HealAll() {
    }

    public static <T extends Player> void healAll(List<T> players, int amount) {
        for (T player : players) {
            player.takeHealth(amount);
        }
    }
}
