package aoc.day09;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
    private final int DAY = 9;
    private final Day09 puzzle = new Day09();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(15, puzzle.part1(input));
        assertEquals(1134, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(594, puzzle.part1(input));
        assertEquals(858494, puzzle.part2(input));
    }

}