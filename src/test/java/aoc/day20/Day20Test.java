package aoc.day20;

import aoc.day18.Day18;
import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day20Test {
    private final int DAY = 20;
    private final Day20 puzzle = new Day20();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(35, puzzle.part1(input));
        assertEquals(3351, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(5316, puzzle.part1(input));
        assertEquals(16728, puzzle.part2(input));
    }
}