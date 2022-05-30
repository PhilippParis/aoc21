package aoc.day12;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    private final int DAY = 12;
    private final Day12 puzzle = new Day12();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(226, puzzle.part1(input));
        assertEquals(3509, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(3497, puzzle.part1(input));
        assertEquals(93686, puzzle.part2(input));
    }
}