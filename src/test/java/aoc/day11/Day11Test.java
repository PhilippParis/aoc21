package aoc.day11;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {
    private final int DAY = 11;
    private final Day11 puzzle = new Day11();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(1656, puzzle.part1(input));
        assertEquals(195, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(1642, puzzle.part1(input));
        assertEquals(320, puzzle.part2(input));
    }

}