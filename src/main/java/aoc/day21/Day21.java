package aoc.day21;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day21 {

    private final DeterministicDice dice = new DeterministicDice();
    private final HashMap<Pair<Player, Player>, Pair<Long, Long>> cache = new HashMap<>();
    private static final List<Integer> distances = new ArrayList<>();
    static {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    distances.add(i + j + k);
                }
            }
        }
    }

    public long part1(List<String> input) {
        Player player1 = new Player(Integer.parseInt(input.get(0).split(": ")[1]));
        Player player2 = new Player(Integer.parseInt(input.get(1).split(": ")[1]));
        return play1(player1, player2) * dice.getRolls();
    }

    public long part2(List<String> input) {
        Player player1 = new Player(Integer.parseInt(input.get(0).split(": ")[1]));
        Player player2 = new Player(Integer.parseInt(input.get(1).split(": ")[1]));
        Pair<Long, Long> resultB = play2(player1, player2);
        return Math.max(resultB.getLeft(), resultB.getRight());
    }

    private long play1(Player player1, Player player2) {
        Player newPlayer1 = player1.move(dice.roll() + dice.roll() + dice.roll());
        if (newPlayer1.getPoints() >= 1000) {
            return player2.getPoints();
        }
        Player newPlayer2 = player2.move(dice.roll() + dice.roll() + dice.roll());
        if (newPlayer2.getPoints() >= 1000) {
            return player1.getPoints();
        }
        return play1(newPlayer1, newPlayer2);
    }

    private Pair<Long, Long> play2(Player player1, Player player2) {
        Pair<Player, Player> key = Pair.of(player1, player2);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (player1.getPoints() >= 21) {
            return Pair.of(1L, 0L);
        }
        if (player2.getPoints() >= 21){
            return Pair.of(0L, 1L);
        }

        long winCountPlayer1 = 0;
        long winCountPlayer2 = 0;
        for (Integer distPlayer1 : distances) {
            Pair<Long, Long> wins = play2(player2, player1.move(distPlayer1));
            winCountPlayer2 += wins.getLeft();
            winCountPlayer1 += wins.getRight();
        }
        Pair<Long, Long> result = Pair.of(winCountPlayer1, winCountPlayer2);
        cache.put(key, result);
        return result;
    }
}
