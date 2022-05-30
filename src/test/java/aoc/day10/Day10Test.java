package aoc.day10;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    private final int DAY = 10;
    private final Day10 puzzle = new Day10();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(26397, puzzle.part1(input));
        assertEquals(288957, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(268845, puzzle.part1(input));
        assertEquals(4038824534L, puzzle.part2(input));
    }
}