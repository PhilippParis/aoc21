package aoc.day14;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {
    private final int DAY = 14;
    private final Day14 puzzle = new Day14();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(1588, puzzle.part1(input));
        assertEquals(2188189693529L, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(3009, puzzle.part1(input));
        assertEquals(3459822539451L, puzzle.part2(input));
    }
}