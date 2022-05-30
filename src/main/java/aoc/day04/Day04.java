package aoc.day04;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day04 {

    public long part1(List<String> input) {
        List<Integer> randoms = getRandoms(input);
        List<BingoBoard> boards = getBoards(input);
        for (int random : randoms) {
            Optional<BingoBoard> winner = boards.stream().filter(i -> i.mark(random)).findFirst();
            if (winner.isPresent()) {
                return winner.get().getSumOfUnmarked() * random;
            }
        }
        return 0;
    }

    public long part2(List<String> input) {
        List<Integer> randoms = getRandoms(input);
        List<BingoBoard> boards = getBoards(input);
        Pair<BingoBoard, Integer> winner = null;
        for (int random : randoms) {
            List<BingoBoard> winners = boards.stream().filter(i -> i.mark(random)).collect(Collectors.toList());
            boards.removeAll(winners);
            if (!winners.isEmpty()) {
                winner = Pair.of(winners.get(0), random);
            }
        }
        return winner == null ? 0 : winner.getLeft().getSumOfUnmarked() * winner.getRight();
    }

    private List<BingoBoard> getBoards(List<String> input) {
        List<BingoBoard> boards = new ArrayList<>();
        for (int i = 7; i <= input.size(); i += 6) {
            boards.add(new BingoBoard(input.subList(i - 5, i)));
        }
        return boards;
    }

    private List<Integer> getRandoms(List<String> input) {
        return Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
