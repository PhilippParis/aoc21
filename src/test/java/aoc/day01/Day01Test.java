package aoc.day01;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    private final int DAY = 1;
    private final Day01 puzzle = new Day01();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(7, puzzle.part1(input));
        assertEquals(5, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(1692, puzzle.part1(input));
        assertEquals(1724, puzzle.part2(input));
    }

}