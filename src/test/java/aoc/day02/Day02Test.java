package aoc.day02;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private final int DAY = 2;
    private final Day02 puzzle = new Day02();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(150, puzzle.part1(input));
        assertEquals(900, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(1692075, puzzle.part1(input));
        assertEquals(1749524700, puzzle.part2(input));
    }

}