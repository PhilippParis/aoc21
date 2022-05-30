package aoc.day15;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15Test {
    private final int DAY = 15;
    private final Day15 puzzle = new Day15();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(40, puzzle.part1(input));
        assertEquals(315, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(361, puzzle.part1(input));
        assertEquals(2838, puzzle.part2(input));
    }
}