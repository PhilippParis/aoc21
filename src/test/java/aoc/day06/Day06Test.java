package aoc.day06;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {
    private final int DAY = 6;
    private final Day06 puzzle = new Day06();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(5934, puzzle.part1(input));
        assertEquals(26984457539L, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(355386, puzzle.part1(input));
        assertEquals(1613415325809L, puzzle.part2(input));
    }
}