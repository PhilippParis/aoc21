package aoc.day10;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day10 {

    public long part1(List<String> input) {
        return input.stream().map(Parser::getIllegalCharacter)
                .filter(Optional::isPresent).mapToInt(i -> getScore1(i.get())).sum();
    }

    public long part2(List<String> input) {
        List<Long> scores = input.stream().map(Parser::getMissingChars)
                .filter(Optional::isPresent).map(i -> getScore2(i.get())).sorted().collect(Collectors.toList());
        return scores.get(scores.size() / 2);
    }

    private int getScore1(Character character) {
        return switch (character) {
            case ')' -> 3;
            case ']' -> 57;
            case '}' -> 1197;
            case '>' -> 25137;
            default -> 0;
        };
    }

    private long getScore2(List<Character> characters) {
        long score = 0;
        for (Character c : characters) {
            score *= 5L;
            score += switch (c) {
                case ')' -> 1;
                case ']' -> 2;
                case '}' -> 3;
                case '>' -> 4;
                default -> 0;
            };
        }
        return score;
    }

}
