package aoc.day05;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    private final int DAY = 5;
    private final Day05 puzzle = new Day05();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(5, puzzle.part1(input));
        assertEquals(12, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(5167, puzzle.part1(input));
        assertEquals(17604, puzzle.part2(input));
    }
}