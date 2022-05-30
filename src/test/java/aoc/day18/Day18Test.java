package aoc.day18;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day18Test {
    private final int DAY = 18;
    private final Day18 puzzle = new Day18();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(4140, puzzle.part1(input));
        assertEquals(3993, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(2907, puzzle.part1(input));
        assertEquals(4690, puzzle.part2(input));
    }
}