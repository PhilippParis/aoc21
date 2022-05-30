package aoc.day19;

import org.junit.jupiter.api.Test;
import util.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day19Test {
    private final int DAY = 19;
    private final Day19 puzzle = new Day19();

    @Test
    void example() {
        puzzle.run(Input.getExample(DAY));
        assertEquals(79, puzzle.part1());
        assertEquals(3621, puzzle.part2());
    }

    @Test
    void input() {
        puzzle.run(Input.getInput(DAY));
        assertEquals(365, puzzle.part1());
        assertEquals(11060, puzzle.part2());
    }
}