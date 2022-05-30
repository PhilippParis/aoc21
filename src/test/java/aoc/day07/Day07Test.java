package aoc.day07;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {
    private final int DAY = 7;
    private final Day07 puzzle = new Day07();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(37, puzzle.part1(input));
        assertEquals(168, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(344605, puzzle.part1(input));
        assertEquals(93699985, puzzle.part2(input));
    }
}