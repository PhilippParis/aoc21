package aoc.day04;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
    private final int DAY = 4;
    private final Day04 puzzle = new Day04();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(4512, puzzle.part1(input));
        assertEquals(1924, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(23177, puzzle.part1(input));
        assertEquals(6804, puzzle.part2(input));
    }
}