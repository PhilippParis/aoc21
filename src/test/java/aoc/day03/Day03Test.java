package aoc.day03;

import org.junit.jupiter.api.Test;
import util.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    private final int DAY = 3;
    private final Day03 puzzle = new Day03();

    @Test
    void example() {
        puzzle.run(Input.getExample(DAY));
        assertEquals(198, puzzle.part1());
        assertEquals(230, puzzle.part2());
    }

    @Test
    void input() {
        puzzle.run(Input.getInput(DAY));
        assertEquals(693486, puzzle.part1());
        assertEquals(3379326, puzzle.part2());
    }

}