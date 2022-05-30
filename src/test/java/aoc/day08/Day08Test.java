package aoc.day08;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {
    private final int DAY = 8;
    private final Day08 puzzle = new Day08();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(26, puzzle.part1(input));
        assertEquals(61229, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(237, puzzle.part1(input));
        assertEquals(1009098, puzzle.part2(input));
    }
}